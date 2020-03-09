package cn.smart.controller;

import cn.smart.vo.Project;
import cn.smart.vo.User;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.json.FastJson;

/**
 * Action参数注入
 */
public class ProjectController extends Controller {

    /**
     *  Action 参数注入可以代替 getPara、getBean、getModel 系列方法获取参数，
     *  使用 File、UploadFile 参数时可以代替 getFile 方法实现文件上传。
     *  这种传参方式还有一个好处是便于与 swagger 这类第三方无缝集成，生成API文档。
     * @param project
     */
    public void index(Project project){
        project.save();
        render("index.html");
    }

    /**
     * 如果 action 形参是一个 model 或者 bean，原先通过 getBean(User.class, "") 获取时第二个参数为空字符串或null，
     * 那么与之等价的形参注入只需要用一下 @Para("") 注解即可：
     * @param user
     */
    public void action(@Para("") User user){

    }

    /**
     * 该方法演示get/getPara系列方法对参数获取
     * @apiNote
     * Controller提供了getPara系列方法用来从请求中获取参数。getPara系列方法分为两种类型。第一种类型为第一个形参为String的getPara系列方法。该系列方法是对HttpServletRequest.getParameter(String name)的封装，这类方法都是转调了HttpServletRequest.getParameter(String name)。
     *
     *     第二种类型为第一个形参为int或无形参的getPara系列方法。该系列方法是去获取urlPara中所带的参数值。getParaMap与getParaNames分别对应HttpServletRequest的getParameterMap与getParameterNames。
     *
     *
     */
    public void getParameter(){
        //按名称获取适用于POST
        //返回页面表单域名为 title 参数值
        String title = getPara("title");
        //获取表单域age属性并转换成int
        Integer age = getParaToInt("age");
        //通过索引获取参数值。例子:http://127.0.0.1/user/getParamter/v2-5-N8
        String para = getPara(0);   //返回url中参数第一个值 return -> v2
        Integer integer = getParaToInt(1);  //返回url中参数第二个值并转成int型 return -> 5
        /* return -> -8 约定字母N或n可以表示符号，这对urlParaSeparator 为 “-” 时非常有用*/
        Integer paraToInt = getParaToInt(2);
        //return -> v2-5-N8
        String allParam = getPara();

        /*3.6更新方法*/
        String title2 = get("title");
        Integer age2 = getInt("age");
        // 替代 setAttr 的 set 用法
//        set("article", article);

        /*
         *   jfinal 3.5 版本新增了 getRawData() 方法，可以很方便地从 http 请求 body 中获取 String 型的数据，
         * 通常这类数据是 json 或 XML 数据
         *
         *
         * 以上代码通过 getRawData() 获取到了客户端传过来的 String 型的 json 数据库。 getRawData() 方法可以在一次请求交互中多次反复调用，不会抛出异常。
            这里要注意一个问题：通过 forwardAction(...) 转发到另一个 action 时，getRawData() 无法获取到数据，
         * 此时需要使用 setAttr("rawData", getRawData()) 将数据传递给 forward 到的目标 action，然后在目标 action 通过 getAttr("rawData") 获取。一般这种情况很少见。
         *
         *
         */

        String json = getRawData();
        User user = FastJson.getJson().parse(json, User.class);


        /*System.out.println("title -> "+title +
                "\nage -> " + age + "\npara -> " + para + "\ninteger -> " + integer +
                "\nparaToInt -> " + paraToInt +"\nallParam -> " + allParam);*/
        renderText("title -> "+title +
                "\nage -> " + age + "\npara -> " + para + "\ninteger -> " + integer +
                "\nparaToInt -> " + paraToInt +"\nallParam -> " + allParam);
    }

}
