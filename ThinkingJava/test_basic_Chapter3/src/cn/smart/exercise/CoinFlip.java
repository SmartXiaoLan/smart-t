package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习7:（3）
 *      编写一个程序，模拟扔硬币的结果。
 *
 */
public class CoinFlip {
    public static void main(String[] args) {
        int rand = (int)(Math.random()*2);
        System.out.println(rand==1?"正面":"反面");
    }
}
