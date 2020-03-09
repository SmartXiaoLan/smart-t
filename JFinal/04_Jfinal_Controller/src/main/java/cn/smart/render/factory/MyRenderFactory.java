package cn.smart.render.factory;

import cn.smart.render.MyRender;
import com.jfinal.render.Render;
import com.jfinal.render.RenderFactory;

public class MyRenderFactory extends RenderFactory {

    // 扩展 RenderFactory，用于将 Controller.render(String view)
    // 切换到自己定制的 MyRender 上去
    public Render getRender(String view){
        return new MyRender(view);
    }

}
