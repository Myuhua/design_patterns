package com.alive.strategy;

/**
 * 猫根据高度的比较器
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height<o2.height) return -1;
        else if(o1.height>o2.height) return 1;
        return 0;
    }
}
