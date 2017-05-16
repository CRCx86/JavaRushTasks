package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

/**
 * Created by a.zinov on 15.05.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<E, Object>(Math.max(16, (int)(collection.size()/.75f + 1)));

        super.addAll(collection);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (!map.containsKey(e)){
            map.put(e, PRESENT);
            return true;
        }else {
            map.put(e, PRESENT);
            return false;
        }

    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        AmigoSet<E> amigoSet = new AmigoSet<>();
        try {

            amigoSet.addAll(this);
            amigoSet.map.putAll((Map<? extends E, ?>) this.map.clone());

        } catch (Exception e){
            throw new InternalError();
        }

        return amigoSet;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        objectOutputStream.writeInt((Integer) HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        objectOutputStream.writeFloat((Float) HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));

    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {

        objectInputStream.defaultReadObject();

        int capacity = objectInputStream.readInt();
        if (capacity < 0)
            throw new InvalidObjectException("capacity: " + capacity);

        float loadFactor = objectInputStream.readFloat();
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new InvalidObjectException("factor: " + loadFactor);

        map = new HashMap<E, Object>(capacity, loadFactor);
    }
}
