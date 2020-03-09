package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习2
 *      if-else if
 *
 */
public class RandomIfElse {

    public static void main(String[] args) {
        for (int i = 0 ; i < 25 ; i ++){
            int num = (int) (Math.random() * 11+1);
            if (num > 0 && num <= 3) System.out.println("第"+(i+1)+"个" + "数字<3" + "\t===>" + num);
            else if (num > 3 && num <8) System.out.println("第"+(i+1)+"个" + "3<数字<8"+ "\t===>" + num);
            else if (num >= 8 && num <10) System.out.println("第"+(i+1)+"个" + "8<=数字<10"+ "\t===>" + num);
        }
    }
}
