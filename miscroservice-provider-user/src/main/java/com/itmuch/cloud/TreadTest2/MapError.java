package com.itmuch.cloud.TreadTest2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapError {

    public static void main(String [] arg){
        Lock lock = new ReentrantLock();
        lock.lock();
        lockTest();
        lock.unlock();
        Map<String ,String > map = new HashMap<String ,String>();

        map.put("1",null);
        map.put("2","a");
        map.put("3","b");
        map.put("4","c");
        map.put("4","d");
        for (String m:map.keySet()) {
            System.out.println(m);
        }
    }

    public static void lockTest(){
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println("susus");
        lock.unlock();
    }

}
