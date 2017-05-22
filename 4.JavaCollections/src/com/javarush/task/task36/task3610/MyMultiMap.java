package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {

        int result = 0;

        for (List<V> v : map.values()) {
            result += v.size();
        }
        return result;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код

        List<V> list = map.get(key);
        V oValue = null;

        if (list == null) {
            list = new ArrayList<V>();
        }else {

            oValue = list.get(list.size() - 1);
            if (list.size() == repeatCount)
                list.remove(0);
        }

        list.add(value);
        map.put(key, list);
        return oValue;

    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код

        List<V> vs = map.get(key);
        if (vs == null)
            return null;

        V v1 = vs.get(0);
        vs.remove(0);

        if (vs.size() == 0) {
            map.remove(key);
        }

        return v1;

    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> arrayList = new ArrayList<V>();
        for (List<V> v : map.values()) {
            arrayList.addAll(v);
        }

        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код

        for (List<V> v : map.values()) {
            if (v.contains(value))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}