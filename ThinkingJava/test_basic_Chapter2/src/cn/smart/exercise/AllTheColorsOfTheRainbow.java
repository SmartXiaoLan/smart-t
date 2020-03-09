package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习11(1)：
 *      将AllTheColorsOfTheRainbow这个示例改成一个程序，然后编译，运行。
 *
 */
public class AllTheColorsOfTheRainbow {

    int anIntegerRepresentingColors;

    void changeTheHueOfTheColor(int newHue){
        this.anIntegerRepresentingColors = newHue;
    }

    public static void main(String[] args) {
        AllTheColorsOfTheRainbow rainbow = new AllTheColorsOfTheRainbow();
        rainbow.changeTheHueOfTheColor(548);
        System.out.println(rainbow.anIntegerRepresentingColors);
    }
}
