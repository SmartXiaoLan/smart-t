/**
 * @author Smart-T
 * 例子类：
 *      用于考察测试String在内存中的引用
 */
public class StringObjectPlaceExample {

    String str = new String("good");
    char [] ch = {'a','b','c'};

    /**
     * 干扰方法
     *
     */
    public void change(String str , char ch[]){
        str = "test ok";
        //this.str = "test ok";
        ch[0] = 'g';
    }
    public static void main(String[] args){
        StringObjectPlaceExample demo = new StringObjectPlaceExample();
        demo.change(demo.str,demo.ch);
        System.out.println(demo.str+"and");
        System.out.println(demo.ch);
    }
}
