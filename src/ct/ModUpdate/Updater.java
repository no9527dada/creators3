package ct.ModUpdate;

import java.io.*;
import arc.struct.*;
import arc.util.*;
import arc.files.*;
import mindustry.*;
import mindustry.mod.*;

public class Updater {

    public static final String url = "https://raw.githubusercontent.com/";
    public static final String tokenVersion = "VERSION", tokenRepo = "REPO", tokenBranch = "BRANCH", tokenNoUpdate = "NO_UPDATE";
    //temporary builder
    public static final StringBuilder check = new StringBuilder();

    //used for Relfect.invoke
    static final Object[] args = {null, false};
    static final Class[] args2 = {String.class, boolean.class};

    public static void checkUpdates(Mod originMod) {
        var mod = Vars.mods.getMod(originMod.getClass());
        var file = mod.file;

        Fi meta = null;
        if (file == null) {
            Log.err("Failed to check updates for: " + mod.name);
            return;
        } else if (file.isDirectory()) {
            meta = getMeta(file);
        } else {
            meta = getMeta(new ZipFi(file));
        }

        if (meta == null) {
            Log.err("Unable to locate mod metainfo file for: " + mod.name);
            return;
        }

        Log.info("Reading metainfo for " + mod.name);
        ObjectMap<String, Object> info = readInfo(meta);
        try {
            final String metaname = meta.name();
            final float currentVersion = (Float) info.get(tokenVersion, -1f);
            final String currentRepo = String.valueOf(info.get(tokenRepo, ""));
            final String currentBranch = String.valueOf(info.get(tokenBranch, "master"));

            if (!validate(currentVersion, currentRepo)) return;

            Fi temp = Fi.tempFile("update-check");
            //try to find the file in the root
            Http.get(url + currentRepo + "/" + currentBranch + "/" + metaname)
                    .error(e -> {
                        //try to find it in the assets folder
                        Http.get(url + currentRepo + "/" + currentBranch + "/assets/" + metaname)
                                .error(ee -> {
                                    Log.err("Couldn't fetch the remote metainfo file!"); //i did my best
                                    Log.err(ee);
                                })
                                .submit(r -> {
                                    temp.writeBytes(r.getResult());
                                    tryUpdate(temp, currentVersion, mod);
                                });
                    })
                    .submit(r -> {
                        temp.writeBytes(r.getResult());
                        tryUpdate(temp, currentVersion, mod);
                    });
        } catch (ClassCastException e) {
            Log.err("Incorrect token value!");
            Log.err(e.toString()); //no need to print stack trace
        } catch (Exception e) {
            Log.err(e);
        }
    }

    protected static void tryUpdate(Fi metainfo, float currentVersion, Mods.LoadedMod mod) {
        Log.info("Reading remote metainfo for " + mod.name);
        ObjectMap<String, Object> info = readInfo(metainfo);
        try {
            final float newVersion = (Float) info.get(tokenVersion, -1f);
            final String newRepo = String.valueOf(info.get(tokenRepo, ""));

            if (!info.get(tokenNoUpdate, 0f).equals((Float) 0f)) {
                Log.info("The remote metainfo file doesn't allow to update");
                return;
            }

            if (!validate(newVersion, newRepo)) return;

            if (newVersion > currentVersion) {
                Vars.ui.showCustomConfirm(
                        "Update available",
                        "New version of " + mod.name + " available!",
                        "[green]Update",
                        "[red]Not now",

                        () -> {
                            args[0] = newRepo;
                            Reflect.invoke(Vars.ui.mods, "githubImportMod", args, args2);
                            Vars.ui.mods.show();
                        },

                        () -> {}
                );
            }
        } catch (ClassCastException e) {
            Log.err("Incorrect token value (remote file)!");
            Log.err(e.toString()); //no need to print stack trace
        } catch (Exception e) {
            Log.err(e);
        }
    }

    /** Returns whether the hhh is valid. Prints to console if it isn't. */
    protected static boolean validate(float currentVersion, String currentRepo) {
        if (currentVersion == -1 || currentRepo.equals("")) {
            Log.err("You must specify both current version and repo in your mod.hjson file!");
            Log.err("Specify '#!" + tokenVersion + " number;' and '#!" + tokenRepo + " \"user/repository\"' in your mod.hjson file and try again!");
            Log.err("Version: " + currentVersion + ", repo: " + currentRepo);
            return false;
        } else if (currentRepo.indexOf("/") == -1 || currentRepo.lastIndexOf("/") != currentRepo.indexOf("/")) {
            Log.err("Malformed repository path! Repo must contain only 1 slash character!");
            return false;
        }
        return true;
    }

    public static Fi getMeta(Fi root) {
        return root.child("mod.hjson").exists() ? root.child("mod.hjson")
                : root.child("mod.json").exists() ? root.child("mod.json") : null;
    }

    /** Reads the providen meta-info file and returns an ObjectMap containing all control tokens and their respective values */
    protected static ObjectMap<String, Object> readInfo(Fi meta) {
        ObjectMap<String, Object> map = new ObjectMap(4);

        try (InputStream read = meta.read()) {
            int b = 0;

            global:
            while (b != -1) {
                check.setLength(0);

                //skip to the next #!. ##! will be ignored.
                while ((b = read.read()) != '#' || (b = read.read()) != '!'){
                    if (b == -1) break global;
                    if (b == '\\') read.read(); //skip next character
                }

                //read token name

                while ((b = read.read()) != ' ' && b != '\n') {
                    if (b == -1) break global;
                    check.append((char) b);
                }
                String key = check.toString();
                check.setLength(0);

                if (b == '\n') { //line break right after the token name, assume there's no value
                    map.put(key, "");
                    continue;
                }

                //read token value. can be a string or a float.
                b = read.read();
                if (b == '"') { //it's a string, read till the next " symbol
                    while ((b = read.read()) != '"' && b != '\n') {
                        if (b == -1) break global;
                        check.append((char) b);
                    }
                    String value = check.toString();
                    map.put(key, value);
                } else if (Character.isDigit((char) b)) { //it's a number, read as long as possible
                    check.append((char) b);
                    boolean hasPoint = false;
                    while (Character.isDigit((char) (b = read.read())) || (b == '.' && !hasPoint && (hasPoint = true))) {
                        if (b == -1) break global;
                        check.append((char) b);
                    }

                    try {
                        float value = Float.valueOf(check.toString());
                        map.put(key, value);
                    } catch (Throwable e) {
                        continue global; //somehow they managed to break this failsafe system, ignore this token
                    }
                } else {
                    map.put(key, ""); //it just exists. may not be a token.
                }
            }

            return map;
        } catch (Exception e) {
            Log.err("Exception occurred while reading mod metainfo: " + meta.name(), e);
            return map;
        }
    }

}