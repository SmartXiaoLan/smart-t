package com.smt.sington;

public class TestMySelf {
    public static void main(String[] args) {
        MySelf instance = MySelf.getInstance("男");
        System.out.println(instance);
    }
}
