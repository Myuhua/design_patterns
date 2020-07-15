package com.alive.strategy;

/**
 * 对int[]数据进行跑徐
 */
public class Sorter {
    //排序int[]数据方法
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    //排序单一对象
    public static void sortCat(Cat[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swapCat(arr, i, minPos);
        }
    }

    //排序Object对象方法
    public static void sortObject(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
                swapObject(arr, i, minPos);
            }
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapCat(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapObject(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
