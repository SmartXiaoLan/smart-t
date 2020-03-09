package cn.smart.other;

import cn.smart.service.Service;
import com.jfinal.aop.Aop;

/**
 * 如果需要创建的对象并不是 jfinal 接管的，那么可以使用 Aop.get(...) 方法进行依赖对象的创建以及注入
 */
public class MyKit {

    /**
     * 由于 MyKit 的创建并不是 jfinal 接管的，所以不能使用 @Inject 进行依赖注入。 而 Controller、Interceptor 的创建和组装是由 jfinal 接管的，所以可以使用 @Inject 注入依赖。
     *
     *    有了 Aop.get(...) 就可以在任何地方创建对象并且对创建的对象进行注入。此外还可以使用 Aop.inject(...) 仅仅向对象注入依赖但不创建对象。
     */
    static Service service = Aop.get(Service.class);

    public void doIt(){
        service.justDoIt();
    }

}
