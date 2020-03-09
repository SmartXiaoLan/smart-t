package cn.smart.controller;

import cn.smart.vo.Blog;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;

import javax.servlet.http.HttpServletRequest;

public class BlogController extends Controller {

    @Inject
    private HttpServletRequest request;

    public void save(){
        // 页面的modelName正好是Blog类名的首字母小写
        Blog blog = getModel(Blog.class);
        // 如果表单域的名称为 "otherName.title"可加上一个参数来获取
        blog = getModel(Blog.class, "otherName");

        //request作用域的操作
        set("attrName","value").set("","");//3.6支持,推荐使用
        //3.6以前
        setAttr("attrName","value");
    }

    @NotAction
    public Controller setAttr(String name, Object value) {
        request.setAttribute(name, value);
        return this;
    }

}
/*
    上面代码中，表单域采用了 "blog.title"、"blog.content" 作为表单域的name属性，"blog" 是类文件名称 "Blog" 的首字母变小写， "title" 是blog数据库表的title字段，如果希望表单域使用任意的modelName，只需要在getModel时多添加一个参数来指定，例如：getModel(Blog.class, "otherName")。

     如果希望传参时避免使用modelName前缀，可以使用空串作为modelName来实现：getModel(Blog.class, ""); 这对开发纯API项目非常有用。（getBean 同样适用）

     如果希望在接收时跳过数据转换或者属性名错误异常可以传入true参：getBean(…, true)
 */