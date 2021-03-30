package ru.job4j.collection.map;

import ru.job4j.collection.ForwardLinked;

public interface Maps<K, V> extends Iterable<V> {

    boolean insert(K key, V value);
    boolean delete(K key);
    V get(K key);
    int size();
}
