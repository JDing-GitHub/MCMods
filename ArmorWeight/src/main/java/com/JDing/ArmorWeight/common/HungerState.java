package com.JDing.ArmorWeight.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;

public class HungerState extends Thread {
    private static  boolean isRun=false;

    private final EntityPlayer player;

    public static float multiplier=0.0f;




    HungerState(EntityPlayer player){
        this.player =player;
    }

    public boolean isRun() {
        return isRun;
    }



    @Override
    public void run() {
        System.out.println("ArmorWeight foodExhaustionLevel thread start！");
        isRun=true;
        while(true){
            player.getFoodStats().addExhaustion(multiplier);
//            System.out.println(player.getFoodStats().getSaturationLevel());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
