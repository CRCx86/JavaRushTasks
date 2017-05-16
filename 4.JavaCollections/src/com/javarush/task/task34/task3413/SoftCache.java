package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //напишите тут ваш код
        if (softReference == null)
            return null;
        else {
            return softReference.get();
        }
    }

    public AnyObject put(Long key, AnyObject value) {

        if (get(key) == null) {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
//           softReference.clear();
            return null;
        }else {
            AnyObject anyObject = get(key);
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            softReference.clear();
            return anyObject;
        }

        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {

        if (get(key) == null) {
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            return null;
        }else {
            AnyObject anyObject = get(key);
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            softReference.clear();
            return anyObject;
        }
        //напишите тут ваш код
    }
}