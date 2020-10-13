package com.JDing.ArmorWeight.common;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;

@Mod(modid=ModRegistry.MOD_ID,name=ModRegistry.MOD_NAME,version = "2.1.0")
@Mod.EventBusSubscriber
public class ModRegistry {
    public static final String MOD_ID = "armor_weight";

    public static final String MOD_NAME = "ArmorWeight";

    private static LinkedList<Item> itemsList;

    private static LinkedList<Enchantment> enchantmentsList;

    public static LinkedList<Item> getItemsList() {
        return itemsList;
    }

    public static void setItemsList(LinkedList<Item> itemsList) {
        ModRegistry.itemsList = itemsList;
    }

    public static LinkedList<Enchantment> getEnchantmentsList() {
        return enchantmentsList;
    }

    public static void setEnchantmentsList(LinkedList<Enchantment> enchantmentsList) {
        ModRegistry.enchantmentsList = enchantmentsList;
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event){
        System.out.println(this.getClass().getName()+": start register enchantment!");
        for(Enchantment enchantment:enchantmentsList){
            event.getRegistry().register(enchantment);
        }
    }
}
