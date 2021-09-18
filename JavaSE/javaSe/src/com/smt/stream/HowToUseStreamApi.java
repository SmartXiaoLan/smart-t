package com.smt.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 所属项目：JavaSE
 *
 * @author Smart-T
 * @since 22/09/2020
 */
public class HowToUseStreamApi {

    public static void main(String[] args) {
        /*
            一个简单的迭代StreamAPI写法
         */
        List<Integer> nums = new ArrayList<>();
        for (int a = 1; a <= 100; a++)
            nums.add(a);
        nums.forEach(System.out::println);
    }

}
