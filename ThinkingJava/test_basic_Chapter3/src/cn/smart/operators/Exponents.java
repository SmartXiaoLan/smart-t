package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 指数计数法：
 *      一般运用在科学与工程领域，‘e’代表自然对数的基数，约2.178(JavaMath.E给出了更精确的double型的值)
 *      如:1.39e-43 意味着 1.39*2.718^(-48)
 *      然而后面决定e代表"10的次幂"
 *      即:1.39e-43 意味着 1.39*10^(-48)
 *
 *      如果编译器能够正确识别类型则不需要在后面附加字符。如:float f4 = 1e-43f;
 *      即:大转小强转，小转大自动转。
 *
 */
public class Exponents {
    public static void main(String[] args) {
        // Uppercase and lowercase 'e' are the same
        float expFloat = 1.39E-43f;
        expFloat = 1.39e-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d; // 'd' is optional
        double expDouble2 = 47e47; // Automatically double
        System.out.println(expDouble);
    }
}
/*
    output:
        1.39E-43
        4.7E48
 */