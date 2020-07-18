package com.alive.strategy;

/**
 * 自定义comparable接口，用于排序。
 * @param <T>
 */
public interface Comparable<T> {
    int  compareTo( T o);
}
