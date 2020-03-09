package com.smt.interview;

public class AddNumAndCount {

    private static int add(int a, int count){
        int result = 0;
        String temp = "";
        if (count <= 0) return 0;
        for (int i = 0 ; i < count ; i ++) {
            temp = temp+a;
            result += Integer.parseInt(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1,j=0,month , x;
                for (month = 1 ;month <= 36 ; month ++){
                    x=i;
                    System.out.println(2*i);
                    i=i+j;
                    j=x;
                }
                Thread.currentThread().setName("小鸡");
                System.out.println(Thread.currentThread().getName()+"结束！");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(add(2,6));
                Thread.currentThread().setName("Add");
                System.out.println(Thread.currentThread().getName()+"结束！");
            }
        }).start();

    }

}