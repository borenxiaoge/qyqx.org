package com.boren.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {


    public static void main(String[] args) {
        zz z = new zz();
        for (int i = 0; i < 100; i++) {
            new Thread(z).start();
        }
    }
}

class zz implements Runnable {
    public static  ArrayList<String> sortList = new ArrayList<>();

    public static Object obj = new Object();
    public static Map<String, List<Object>> map = new HashMap<>();

    @Override
    public void run() {

        int seq = 0;
        synchronized (obj) {
            if (!map.containsKey("key") || (int) (map.get("key").get(1)) == 0) {
                List<Object> list = new ArrayList<>();
                list.add(0);
                list.add(100);
                list.add(0);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                map.put("key", list);
            }
            seq = (int) (map.get("key").get(0)) + 1;
            map.get("key").set(0, seq);
            map.get("key").set(1, (int) (map.get("key").get(1)) - 1);
        }
        String str1 = "0";
        sortList.add(str1.concat(String.format("%07d", seq)));
//        System.out.println(str1.concat(String.format("%07d", seq)));
    }
}

