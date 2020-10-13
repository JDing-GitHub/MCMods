package com.JDing.ArmorWeight.common;

import java.util.HashMap;

public class InitItemWeight {





    InitItemWeight(){

    }



//    public void readConfiguration(){
//        try (FileReader fr = new FileReader(CONFIG_PATH); BufferedReader br = new BufferedReader(fr);) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if(line.indexOf('{')==0){
//                    line=line.trim().substring(1,line.length()-1);
//                    String[] node=line.split(":",2);
//                    if(node.length!=1){
//                        configurations.put(node[0],node[1]);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        print(configurations);
//    }

    public static HashMap<String,Integer> initItemWeight(String line){
        HashMap<String,Integer> itemWeight=new HashMap<>();
        if(line.indexOf('{')==0){
            line=line.trim().substring(1,line.length()-1);
            String[] items=line.trim().split(",");
            for(String item:items){
                String[] node=item.split(":",2);
                if(node.length!=1){
                    itemWeight.put(getUName(node[0]),Integer.valueOf(node[1]));
                }
            }
        }
        return itemWeight;
    }



    public static void print(HashMap<String,Integer> configurations){
        for(String key:configurations.keySet()){
            System.out.println("key:"+key+"   value:"+configurations.get(key));
        }
    }


    private static String getUName(String name){
        String[] node=name.split(" ");
        return (node[1].toLowerCase()+node[0]);
    }

}
