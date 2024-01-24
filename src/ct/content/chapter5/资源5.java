package ct.content.chapter5;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.environment.OreBlock;

//方块
public class 资源5 {
    public static OreBlock ore钻石混合物, ore石英, ore镍, ore钴;
    public static Item
            爆破弹, 电池, 放射混合物, 放射沙, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
            黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 钍电池, 相织硅,
            啸动合金, 硬直弹, 钻石, 钻石混合物,
            物品;
    public static Liquid
            制冷液, 辐射混合物, 啸冷剂, 军用液体,
            液体;

    public static void load() {
        石英 = new Item("石英", Color.valueOf("F5F5F5")) {{
            localizedName = "石英";
            hardness = 3;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        碳板 = new Item("碳板", Color.valueOf("696969")) {{
            localizedName = "碳板";
            // hardness = 5;
            //explosiveness=2;
            //radioactivity=12.5F;
            flammability = 3.8f;
            explosiveness = 0.3f;
            description = "重写";
        }};
        铁 = new Item("铁", Color.valueOf("F8F8FF")) {{
            localizedName = "铁";
            //hardness = 3;
            //explosiveness=2;
            //radioactivity=12.5F;
            //flammability=3.8f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        铁板 = new Item("铁板", Color.valueOf("DCDCDC")) {{
            localizedName = "铁板";
            //hardness = 5;
            //explosiveness=2;
            //radioactivity=12.5F;
            //flammability=3.8f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        钴 = new Item("钴", Color.valueOf("4169E1")) {{
            localizedName = "钴";
            hardness = 5;
//            explosiveness=2;
            // radioactivity=1.2F;
            //flammability=0.3f;
            description = "ery hard and brittle metal";
        }};
        镍 = new Item("镍", Color.valueOf("008B8B")) {{
            localizedName = "镍";
            hardness = 6;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        镍板 = new Item("镍板", Color.valueOf("2E8B57")) {{
            localizedName = "镍板";
            // hardness = 4;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        钻石混合物 = new Item("钻石混合物", Color.valueOf("008B8B")) {{
            localizedName = "钻石混合物";
            //hardness = 6;
            //explosiveness=2;
            //radioactivity=1.2F;
            flammability = 1.5945f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        钻石 = new Item("钻石", Color.valueOf("00F5FF")) {{
            localizedName = "钻石";
            //hardness = 5;
            //explosiveness=2;
            //radioactivity=1.2F;
            flammability = 2.234f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        钻石矿 = new Item("钻石矿", Color.valueOf("008B8B")) {{
            localizedName = "钻石矿";
            hardness = 6;
            //explosiveness=2;
            //radioactivity=1.2F;
            flammability = 1.5945f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        相织硅 = new Item("相织硅", Color.valueOf("FFDAB9")) {{
            localizedName = "相织硅";
            //hardness = 5;
            //explosiveness=2;
            radioactivity = 1.2F;
            //flammability=0.3f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        金 = new Item("金", Color.valueOf("CD950C")) {{
            localizedName = "金";
            //hardness = 4;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        钛合金 = new Item("钛合金", Color.valueOf("7AC5CD")) {{
            localizedName = "钛合金";
            //hardness = 5;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};

        空壳 = new Item("空壳", Color.valueOf("FFF8DC")) {{
            localizedName = "空壳";
            //hardness = 4;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        钍电池 = new Item("钍电池", Color.valueOf("FF1493")) {{
            localizedName = "钍电池";
            //hardness = 5;
            //explosiveness=2;
            radioactivity = 1.4F;
            flammability = 0.3f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        电池 = new Item("电池", Color.valueOf("87CEFF")) {{
            localizedName = "液电池";
//            hardness = 2;
//            explosiveness=2;
//            flammability=0.3F;
            description = "Cooled thorium battery for turret core";
        }};

        水瓶 = new Item("水瓶", Color.valueOf("1E90FF")) {{
            localizedName = "水瓶";
            // hardness = 3;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        冷冻弹 = new Item("冷冻弹", Color.valueOf("87CEEB")) {{
            localizedName = "冷冻弹";
            //hardness = 4;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        碎裂弹 = new Item("碎裂弹", Color.valueOf("BDB76B")) {{
            localizedName = "碎裂弹";
            // hardness = 3;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};
        爆破弹 = new Item("爆破弹", Color.valueOf("CD5555")) {{
            localizedName = "爆破弹";
            hardness = 2;
            explosiveness = 2;
            flammability = 0.3F;
            description = "A mixture of explosive mixtures, often used as cannon ammunition";
        }};
        硬直弹 = new Item("硬直弹", Color.valueOf("8B7D7B")) {{
            localizedName = "硬直弹";
            // hardness = 5;
            //explosiveness=2;
            // radioactivity=1.2F;
            //flammability=0.3f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        放射沙 = new Item("放射沙", Color.valueOf("FFC125")) {{
            localizedName = "放射沙";
//            hardness = 2;
//            explosiveness=2;
            radioactivity = 1.2F;
            //flammability=0.3f;
            description = "经过辐射后的沙子，未经过处理会很危险";
        }};
        放射混合物 = new Item("放射混合物", Color.valueOf("FF6A6A")) {{
            localizedName = "放射混合物";
//            hardness = 2;
//            explosiveness=2;
            radioactivity = 1.5F;
            flammability = 0.3f;
            description = "A product of a mixture of thorium and explosives, often used in large factories";
        }};
        固体放射物 = new Item("固体放射物", Color.valueOf("CD950C")) {{
            localizedName = "固体放射物";
            //hardness = 4;
//            explosiveness=2;
            radioactivity = 12.5F;
            flammability = 0.5f;
            description = "重写";
        }};
        啸动合金 = new Item("啸动合金", Color.valueOf("FFFF00")) {{
            localizedName = "啸动合金";
            //hardness = 5;
            //explosiveness=2;
            // radioactivity=1.2F;
            //flammability=0.3f;
            //explosiveness=0.3f;
            description = "重写";
        }};
        黎辉水晶 = new Item("黎辉水晶", Color.valueOf("FFFF00")) {{
            localizedName = "黎辉水晶";
            //hardness = 4;
//            explosiveness=2;
            //radioactivity=12.5F;
            // flammability=0.5f;
            description = "重写";
        }};


        辐射混合物 = new Liquid("辐射混合物", Color.valueOf("FFC125")) {{
            localizedName = "辐射混合物";
            temperature = 0.8f;
            viscosity = 0.6f;
            flammability =
                    heatCapacity =
                            explosiveness = 0;
            description = "重写";
        }};
        制冷液 = new Liquid("制冷液", Color.valueOf("00BFFF")) {{
            localizedName = "制冷液";
            temperature = 0f;
            viscosity = 0.8f;
            flammability = 0f;
            heatCapacity = 1.5f;
            explosiveness = 0;
            description = "重写";
        }};

        军用液体 = new Liquid("军用液体", Color.valueOf("F7F7F7")) {{
            localizedName = "军用液体";
            temperature = 5.0f;
            viscosity = 0f;
            flammability = 0.3f;
            heatCapacity = 0;
            explosiveness = 5;
            description = "重写";
        }};
        啸冷剂 = new Liquid("啸冷剂", Color.valueOf("18A044")) {{
            localizedName = "啸冷剂";
            temperature = 0f;
            viscosity = 2.5f;
            flammability = 0f;
            heatCapacity = 4;
            explosiveness = 0;
            description = "重写";
        }};


        ore钴 = new OreBlock(钴) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.86f;
            oreScale = 17.46f;
        }};
        ore镍 = new OreBlock(镍) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.8f;
            oreScale = 22.45f;
        }};
        ore石英 = new OreBlock(石英) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 19.96f;
        }};
        ore钻石混合物 = new OreBlock(钻石矿) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.86f;
            oreScale = 22.45f;
        }};


    }
}