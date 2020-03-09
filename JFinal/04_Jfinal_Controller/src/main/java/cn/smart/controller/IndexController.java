package cn.smart.controller;

import cn.smart.render.MyRender;
import cn.smart.vo.User;
import com.jfinal.core.Controller;

import java.util.ArrayList;

public class IndexController extends Controller {

    public void demo(){
        // 模板指向 : "/_view/index/abc.html"
        //上述的 render("abc.html") 将指向 webapp 目录下面的 "/_view/index/abc.html" 这个模板。
        render("abc.html");
        //需要打破 baseViewPath 与 viewPath 这两个参数的限制时
        render("/other_path/my_path/index.html");
    }

    //其他render
    /**
     * render系列方法将渲染不同类型的视图并返回给客户端。
     * JFinal目前支持的视图类型有：JFinal Template、FreeMarker、JSP、Velocity、JSON、File、Text、Html、QrCode 二维码 等等。
     * 除了JFinal支持的视图型以外，还可以通过继承Render抽象类来无限扩展视图类型。
     */
    public void demo2(){
        // 渲染名为test.html的视图，且视图类型为 JFinal Template
        renderTemplate("test.html");

        // 生成二维码
        renderQrCode("content",1,1);

        // 渲染名为test.html的视图，且视图类型为FreeMarker
        renderFreeMarker("test.html");

        // 渲染名为test.html的视图，且视图类型为Velocity
        renderVelocity("test.html");

        // 将所有setAttr(..)设置的变量转换成 json 并渲染
        renderJson();

        // 以 "users" 为根，仅将 userList 中的数据转换成 json 并渲染
        renderJson("users", new ArrayList<String>());

        // 将user对象转换成 json 并渲染
        renderJson(new User());

        // 直接渲染 json 字符串
        renderJson("{\"age\":18}" );

        // 仅将setAttr(“user”, user)与setAttr(“blog”, blog)设置的属性转换成json并渲染
        renderJson(new  String[]{"user", "blog"});

        // 渲染名为test.zip的文件，一般用于文件下载
        renderFile("test.zip");

        // 渲染纯文本内容 "Hello JFinal"
        renderText("Hello JFinal");

        // 渲染 Html 内容 "Hello Html"
        renderHtml("Hello Html");

        // 渲染名为 test.html 的文件，且状态为 404
        renderError(404 , "test.html");

        // 渲染名为 test.html 的文件，且状态为 500
        renderError(500 , "test.html");

        // 不渲染，即不向客户端返回数据
        renderNull();

        // 使用自定义的MyRender来渲染
        render(new MyRender());


        /**
         * 注意：
         *
         * 1：IE不支持contentType为application/json,在ajax上传文件完成后返回json时IE提示下载文件,解决办法是使用：render(new JsonRender().forIE())或者render(new JsonRender(params).forIE())。这种情况只出现在IE浏览器 ajax 文件上传，其它普通ajax请求不必理会。
         *
         * 2：除renderError方法以外，在调用render系列的方法后程序并不会立即返回，如果需要立即返回需要使用return语句。在一个action中多次调用render方法只有最后一次有效。
         */



    }
}
