package com.smt.string;

import java.util.Arrays;

public class SortBy {
    //冒泡排序
    private static int [] sortBy(int[] arr){

        int temp ;
        boolean flag;
        for (int i = 0 ; i < arr.length-1 ; i ++){
            flag = true;
            for (int j = 0 ; j < arr.length-1-i ;j ++ ){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false; // 数组中的元素无序，发生交换
                }
            }
            if(flag) break;;
        }
        return arr;
    }

    //ArrayList实现原理


    //链表

    //二分查找

    public static void main(String[] args) {
        int [] arr = {0,5,112,2,6,8,1,12,9};
        int[] ints = SortBy.sortBy(arr);
        System.out.println(Arrays.toString(ints));
    }
}
