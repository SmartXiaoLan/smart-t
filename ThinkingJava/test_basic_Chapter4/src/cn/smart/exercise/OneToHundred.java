package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习1:从1打印到100.
 *
 */
public class OneToHundred {

    public static void main(String[] args) {
        int step = 1;
        while (step <= 100){
            System.out.print(step == 100 ? step++  : step+++"、");
        }
    }

}
