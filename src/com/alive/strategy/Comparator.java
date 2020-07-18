package com.alive.strategy;

/**
 * 策略模式
 * 比较器：写比较器
 * 使用比较器接口，实现比较器接口可以将比较方法释放，具体的比较规则可以在实例的比较器中实现
 * 使用comparable接口 只能实现一种排序策略
 * ，使用比较器可以实现多种
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1 ,T o2);
}
