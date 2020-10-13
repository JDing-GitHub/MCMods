package com.JDing.ArmorWeight.common;

import net.minecraftforge.common.config.Config;

@Config(modid = InitialWeight.MOD_ID,type = Config.Type.INSTANCE,name=InitialWeight.MOD_NAME)
public class ModConfiguration {
    public static  float OVER_WEIGHT_SPEED=0.06f;

    public static  float LITTLE_WEIGHT_SPEED=0.08f;

    public static  float INIT_SPEED=0.1f;

    public static  int  OVER_WEIGHT=37;

    public static  int  LITTLE_WEIGHT=15;

    public static  float INIT_FALL_DAMAGE=1.0f;

    public static  float LITTLE_WEIGHT_FALL_DAMAGE=1.5f;

    public static  float OVER_WEIGHT_FALL_DAMAGE=2.0f;

    public static float INIT_FOOD_EXHAUSTION=0.0f;

    public static float LITTLE_FOOD_EXHAUSTION=0.2f;

    public static float OVER_FOOD_EXHAUSTION=0.5f;


    public static String DEFAULT_ITEM_WEIGHT="{Leather HelmetLeather:2,Leather Tunic:4,Leather Pants:2,Leather Boots:1,Chainmail Helmet:6,Chainmail Chestplate:14,Chainmail Leggings:7,Chainmail Boots:6,Iron Helmet:9,Iron Chestplate:18,Iron Leggings:10,Iron Boots:7,Diamond Helmet:7,Diamond Chestplate:16,Diamond Leggings:8,Diamond Boots:6,Golden Helmet:5,Golden Chestplate:11,Golden Leggings:6,Golden Boots:4}";

    public static String EXTEND_ITEM_WEIGHT="{}";

//    public static DefaultItemWeight DEFAULT_ITEM_WEIGHT;
//
//
//    private static class DefaultItemWeight{
//        public static  int Leather_Helmet=2;
//        public static  int Leather_Tunic=4;
//        public static  int Leather_Pants=2;
//        public static  int Leather_Boots=1;
//        public static  int Chainmail_Helmet=6;
//        public static  int Chainmail_Chestplate=14;
//        public static  int Chainmail_Leggings=7;
//        public static  int Chainmail_Boots=6;
//        public static  int Iron_Helmet=9;
//        public static  int Iron_Chestplate=18;
//        public static  int Iron_Leggings=10;
//        public static  int Iron_Boots=7;
//        public static  int Diamond_Helmet=7;
//        public static  int Diamond_Chestplate=16;
//        public static  int Diamond_Leggings=8;
//        public static  int Diamond_Boots=6;
//        public static  int Golden_Helmet=5;
//        public static  int Golden_Chestplate=11;
//        public static  int Golden_Leggings=6;
//        public static  int Golden_Boots=4;
//
//
//    }



}
