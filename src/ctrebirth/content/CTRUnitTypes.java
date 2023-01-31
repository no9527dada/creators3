package ctrebirth.content;

import mindustry.Vars;
import mindustry.ai.types.HugAI;
import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.type.UnitType;

//UnitTypes.latum.hidden = false
public class CTRUnitTypes {
    //陆军
    public static UnitType  mace, dagger, crawler, fortress, scepter, reign, vela;
    //空军
    public static UnitType  flare, eclipse, horizon, zenith, antumbra, avert, obviate;
    //空辅
    public static UnitType mega, evoke, incite, emanate, quell, disrupt;
    //地爬
    public static UnitType corvus, atrax, merui, cleroi, anthicus, tecta, collaris;
    //虫子
    public static UnitType latum1,renale1;
    //坦克

    public static class CTRUnitType extends UnitType{
        public CTRUnitType(String name, String MDTName) {
            super(name);

            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
        }
    }
    public static void load(){

        renale1 = new CTRUnitType("renale","renale"){{
            health = 500;
            armor = 2;
            hitSize = 9f;
            omniMovement = false;
            rotateSpeed = 2.5f;
            drownTimeMultiplier = 2f;
            segments = 3;
            drawBody = false;
            hidden = false;
            crushDamage = 0.5f;
            aiController = HugAI::new;
            targetAir = false;

            segmentScl = 3f;
            segmentPhase = 5f;
            segmentMag = 0.5f;
            speed = 1.2f;
        }};

        latum1 = new CTRUnitType("latum","latum"){{
            health = 20000;
            armor = 12;
            hitSize = 48f;
            omniMovement = false;
            rotateSpeed = 1.7f;
            drownTimeMultiplier = 4f;
            segments = 4;
            drawBody = false;
            hidden = false;
            crushDamage = 2f;
            aiController = HugAI::new;
            targetAir = false;

            segmentScl = 4f;
            segmentPhase = 5f;
            speed = 1f;

            abilities.add(new SpawnDeathAbility(renale1, 5, 11f));
        }};

    }
}
