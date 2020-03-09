package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习4：(2)
 *      编写一个计算速度的程序，它所使用的距离和时间都是常量。
 *
 */
public class ExerciseOps {

    /**
     *
     * @param seconds   秒
     * @param distance 米
     * @return m/s
     */
    public static float calculatorSpeed(int seconds , float distance){
        return distance/seconds;
    }

    public static void main(String[] args) {
        int seconds = 20;
        float distance = 300;
        float v = calculatorSpeed(seconds, distance);
        System.out.println("路程:"+distance +"m\t用时:"+seconds+"s\t速度为:" + v +"m/s");
    }
}
