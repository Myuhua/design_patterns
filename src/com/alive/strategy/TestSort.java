package com.alive.strategy;


import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] aInt = {2, 1, 10, 7, 5, 6, 9};
        Sorter sorter = new Sorter();
        sorter.sort(aInt);
        System.out.println(Arrays.toString(aInt));

        Sorter sorter1 = new Sorter();
        Cat cat = new Cat(3, 3);
        Cat cat2 = new Cat(5, 5);
        Cat cat3 = new Cat(1, 1);
        Cat[] cats = {cat, cat2, cat3};
        sorter1.sortCat(cats);
        System.out.println(Arrays.toString(cats));

        Sorter sorter3 = new Sorter();
        Cat cat4 = new Cat(3, 3);
        Cat cat5 = new Cat(5, 5);
        Cat cat6 = new Cat(1, 1);
        Cat[] catss = {cat4, cat5, cat6};
        sorter3.sortObject(catss);
        System.out.println(Arrays.toString(catss));

        Sorter sorter4 = new Sorter();
        Cat cat7 = new Cat(3, 3);
        Cat cat8 = new Cat(5, 5);
        Cat cat9 = new Cat(1, 1);
        Cat[] catsss = {cat7, cat8, cat9};
        sorter4.sortObjectByComparator(catsss,new CatWeightComparator());
        System.out.println(Arrays.toString(catss));

        Sorter sorter5 = new Sorter();
        Cat cat10 = new Cat(3, 5);
        Cat cat11 = new Cat(5, 3);
        Cat cat12 = new Cat(1, 1);
        Cat[] catssss = {cat10, cat11, cat12};
        sorter5.sortObjectByComparator(catssss,new CatHeightComparator());
        System.out.println(Arrays.toString(catssss));

    }

}
