package com.JDing.ArmorWeight.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;


@Mod.EventBusSubscriber
public class InitialWeight {
    public static final String MOD_ID = "armor_weight";

    public static final String MOD_NAME = "ArmorWeight";

    public static HashMap<String,Integer> itemWeight;


    @Mod.EventHandler
    public void initial(FMLInitializationEvent event){
        ConfigManager.sync(InitialWeight.MOD_ID, Config.Type.INSTANCE);


        itemWeight=InitItemWeight.initItemWeight(ModConfiguration.DEFAULT_ITEM_WEIGHT);

        itemWeight.putAll(InitItemWeight.initItemWeight(ModConfiguration.EXTEND_ITEM_WEIGHT));
//        InitItemWeight.print(itemWeight);
    }





    @SubscribeEvent
    public static void initWeight(LivingEquipmentChangeEvent event) {
      if(event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = event.getEntityLiving().getEntityWorld().getPlayerEntityByName(event.getEntityLiving().getName());

            ArmorWeight armorWeight = new ArmorWeight();


            assert player != null;
            System.out.println(armorWeight.getFinalSpeed(player));
            player.capabilities.setPlayerWalkSpeed(armorWeight.getFinalSpeed(player));
            System.out.println("speed:" +player.getAIMoveSpeed());

            HungerState.multiplier=armorWeight.getFinalSaturationLevel();

//            System.out.println("SaturationLevel:"+player.getFoodStats().getFoodLevel());
        }
    }


    @SubscribeEvent
    public static void registerItem(LivingFallEvent event){
        if(event.getEntityLiving() instanceof EntityPlayer){
            ArmorWeight armorWeight = new ArmorWeight();
            event.setDamageMultiplier(armorWeight.getFinalFallDamage());
            System.out.println("Damage Multiplier:"+event.getDamageMultiplier());
        }

    }

    @SubscribeEvent
    public static void test(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof EntityPlayer){
            HungerState hungerState =new HungerState((EntityPlayer)event.getEntity());
            if(!hungerState.isRun()){
                hungerState.start();
            }
        }
    }
}



