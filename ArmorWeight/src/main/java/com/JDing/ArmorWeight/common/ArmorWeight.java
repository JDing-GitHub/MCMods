package com.JDing.ArmorWeight.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class ArmorWeight {
    private static int equipmentsWeight;


    ArmorWeight() {
    }

    public static int getEquipmentsWeight() {
        return equipmentsWeight;
    }

    public void print(HashMap<String,Integer> configurations){
        for(String key:configurations.keySet()){
            System.out.println("key:"+key+"   value:"+configurations.get(key));
        }
    }

    public void initWeight(EntityPlayer player) {
        Integer temWeight=0;
        equipmentsWeight=0;
        int i=0;
        for (ItemStack itemStack : player.getArmorInventoryList()) {
            System.out.println(itemStack.getEnchantmentTagList());

//            System.out.println(itemStack.getUnlocalizedName()+" weight:"+temWeight);
           if(InitialWeight.itemWeight.containsKey(getName(itemStack.getUnlocalizedName()))){
               temWeight=InitialWeight.itemWeight.get(getName(itemStack.getUnlocalizedName()));
           }
           equipmentsWeight+=temWeight;
        }

//        if((temWeight=InitConfiguration.configuration.getItemWeight().get(player.getHeldItemMainhand().getDisplayName()))!=null){
//            equipmentsWeight+=temWeight;
//        }
//        if((temWeight=InitConfiguration.configuration.getItemWeight().get(player.getHeldItemOffhand().getDisplayName()))!=null){
//            equipmentsWeight+=temWeight;
//        }
        System.out.println("totalWeight:"+equipmentsWeight);
    }

    public float getFinalSpeed(EntityPlayer player){
        initWeight(player);
        if(equipmentsWeight<=ModConfiguration.LITTLE_WEIGHT){
            return ModConfiguration.INIT_SPEED;
        }
        else if(equipmentsWeight <= ModConfiguration.OVER_WEIGHT){
            return ModConfiguration.LITTLE_WEIGHT_SPEED;
        }
        else {
            return ModConfiguration.OVER_WEIGHT_SPEED;
        }
    }

    public float getFinalFallDamage(){
        if(equipmentsWeight<=ModConfiguration.LITTLE_WEIGHT){
           return ModConfiguration.INIT_FALL_DAMAGE;
        }
        else if(equipmentsWeight<=ModConfiguration.OVER_WEIGHT){
            return ModConfiguration.LITTLE_WEIGHT_FALL_DAMAGE;
        }
        else {
            return ModConfiguration.OVER_WEIGHT_FALL_DAMAGE;
        }
    }

    public float getFinalSaturationLevel(){
        if(equipmentsWeight<=ModConfiguration.LITTLE_WEIGHT){
            return ModConfiguration.INIT_FOOD_EXHAUSTION;
        }
        else if(equipmentsWeight<=ModConfiguration.OVER_WEIGHT){
            return ModConfiguration.LITTLE_FOOD_EXHAUSTION;
        }
        else {
            return ModConfiguration.OVER_FOOD_EXHAUSTION;
        }
    }

    private String getName(String unlocalizedName){
        String[] strs=unlocalizedName.split("\\.");
        return strs[strs.length-1];
    }
}
