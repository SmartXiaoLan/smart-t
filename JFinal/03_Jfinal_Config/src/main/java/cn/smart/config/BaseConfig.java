package cn.smart.config;

import cn.smart.controller.HelloController;
import cn.smart.handler.ResourceHandler;
import cn.smart.interceptor.AuthInterceptor;
import cn.smart.interceptor.FrontInterceptor;
import cn.smart.pojo.User;
import cn.smart.routes.AdminRoutes;
import cn.smart.routes.FrontRoutes;
import com.jfinal.config.*;
import com.jfinal.core.Controller;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

/**
 * 配置JFinalConfig需要继承JFinalConfig
 */
public class BaseConfig extends JFinalConfig {

    /**
     * 用与JFinal常量值的配置
     * @param constants
     */

    @Override
    public void configConstant(Constants constants) {
        //配置开发模式，true为开发模式。默认为False
        /*
            在开发模式下，JFinal会对每次请求输出报告，如输出本次请求的URL、Controller、Method以及请求所携带的参数。
         */
        constants.setDevMode(true);
        //配置aop代理使用cglib，否则将使用jfinal默认的动态编译代理.cglib需要引入
        constants.setToCglibProxyFactory();

        //配置依赖注入。默认FALSE
        constants.setInjectDependency(true);

        //配置依赖注入时，是否对被注入类的超类进行注入.默认False
        constants.setInjectSuperClass(false);

        // 配置为 slf4j 日志系统，否则默认将使用 log4j
        // 还可以通过 me.setLogFactory(...) 配置为自行扩展的日志系统实现类
        constants.setToSlf4jLogFactory();

        //设置JSON转换工厂实现类，更多说明见后续项目
        constants.setJsonFactory(new MixedJsonFactory());

        //配置视图类型，默认使用JFinal enjoy模板引擎
        constants.setViewType(ViewType.JFINAL_TEMPLATE);

        //配置基础下载路径，默认为WebApp下的download
        constants.setBaseDownloadPath("PATH");

        //配置基础上传路径，默认为webapp下的upload
        constants.setBaseUploadPath("PATH");

        //配置404、500页面
        constants.setError404View("PAGE PATH");
        constants.setError500View("PAGE PATH");

        // _______________________________________________________________________________________________________

        //配置Encoding，默认UTF-8
        constants.setEncoding("UTF8");

        //配置json转换Date类型时使用data parttern
        constants.setJsonDatePattern("yyyy-MM-dd HH:mm:ss");

        //配置是否拒绝访问JSP，是直接访问.jsp文件，与renderJsp(xxx.jsp)无关
        constants.setDenyAccessJsp(true);

        //配置上传文件最大数据量，默认10M
        constants.setMaxPostSize(10 * 1024 * 1024);

        //配置验证码缓存 cache，配置成集中共享缓存可以支持分布式与集群
//        constants.setCaptchaCache(...);

        // 配置 urlPara 参数分隔字符，默认为 "-"
        constants.setUrlParaSeparator("-");
    }

    /**
     * 此方法用来配置访问路由
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        //如果要将控制器超类中的 public 方法映射为 action 配置成 true，一般不用配置
        routes.setMappingSuperClass(false);

        /*
            Routes.setBaseViewPath(baseViewPath) 方法用于为该 Routes 内部的所有 Controller 设置视图渲染时的基础路径，该基础路径与Routes.add(…, viewPath) 方法传入的viewPath以及 Controller.render(view) 方法传入的 view 参数联合组成最终的视图路径，规则如下：

            finalView = baseViewPath + viewPath + view

            注意：当view以 “/” 字符打头时表示绝对路径，baseViewPath 与 viewPath 将被忽略。
         */
        routes.setBaseViewPath("/view");
        routes.addInterceptor(new FrontInterceptor());
        routes.add("/hello", HelloController.class);

        //自己配置Routes
        routes.add(this.add("",HelloController.class));


        //路由拆分、模块化(推荐大项目使用)
        routes.add(new FrontRoutes());
        routes.add(new AdminRoutes());

    }

    /*
        路由配置API
         第一个参数 controllerKey 是指访问某个 Controller 所需要的一个字符串，该字符串唯一对应一个 Controller，controllerKey仅能定位到Controller。

        第二个参数 controllerClass 是该 controllerKey 所对应到的 Controller 。

        第三个参数viewPath是指该Controller返回的视图的相对路径(该参数具体细节将在Controller相关章节中给出)。当viewPath未指定时默认值为controllerKey。
     */
    public Routes add(String controllerKey, Class<? extends Controller> controllerClass , String viewPath){
        return null;
    }

    public Routes add(String controllerKey, Class<? extends Controller> controllerClass){
        return new Routes() {
            @Override
            public void config() {
                add("/hello", HelloController.class);
                add("/hello", HelloController.class);
                add("/hello", HelloController.class);
            }
        };
    }


    /**
     * 此方法用来配置Template Engine
     * @param engine
     */
    @Override
    public void configEngine(Engine engine) {
        engine.addSharedFunction("/view/common/layout.html");
        engine.addSharedFunction("/view/common/paginate.html");
        engine.addSharedFunction("/view/admin/common/layout.html");

        /*
            注意：me.setToClassPathSourceFactory()、me.setBaseTemplatePath(...)、me.setDevMode(...)
            这三个配置要放在最前面，因为后续的 me.addSharedFunction(...) 等配置对前面三个配置有依赖。
         */
    }

    /**
     * 方法用于配置JFinal的Plugin
     * @param plugins
     *   JFinal插件架构是其主要扩展方式之一，可以方便地创建插件并应用到项目中去。
     */
    @Override
    public void configPlugin(Plugins plugins) {
        //如Druid数据库链接池插件与ActiveRecord数据库访问插件。
        DruidPlugin dp = new DruidPlugin("jdbcUrl","userName","passWord");
        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("user", User.class);
        plugins.add(arp);
    }

    /**
     * 此方法用来配置JFinal全局拦截器全局拦截器将拦截所有 <<action>> 请求，
     * 除非使用@Clear在Controller中清除，如下代码配置了名为AuthInterceptor的拦截器。
     * @param interceptors
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new AuthInterceptor());
        /*
            JFinal 的 Interceptor 非常类似于 Struts2，
            但使用起来更方便，Interceptor 配置粒度分为 Global、Inject、Class、Method四个层次，
            其中以上代码配置粒度为全局。
         */
    }

    /**
     * 此方法用来配置JFinal的Handler，如下代码配置了名为ResourceHandler的处理器，
     * Handler可以接管所有web请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩展。
     * @param handlers
     *
     * 注意：Handler 是全局共享的，所以要注意其中声明的属性的线程安全问题
     */
    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ResourceHandler());
    }

    //系统启动完成后回调

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("我被调用了。系统启动了！！！");
    }

    //系统关闭之前回调

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("我被调用了。系统关闭了！！！");
    }
}

/*  详见文档
    PropKit工具类用来读取外部键值对配置文件，PropKit可以极度方便地在系统任意时空使用，配置文件的格式如下：

    userName=james
    email=no-reply@jfinal.com
    devMode=true


        如下是 PropKit 代码示例：

    PropKit.use("config.txt");
    String userName = PropKit.get("userName");
    String email = PropKit.get("email");

    // Prop 配合用法
    Prop p = PropKit.use("config.txt");
    Boolean devMode = p.getBoolean("devMode");


        如下是在项目中具体的使用示例：

    public class AppConfig extends JFinalConfig {
      public void configConstant(Constants me) {
        // 第一次使用use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
      }

      public void configPlugin(Plugins me) {
        // 非第一次使用use加载的配置，需要通过每次使用use来指定配置文件名再来取值
        String redisHost = PropKit.use("redis_config.txt").get("host");
        int redisPort = PropKit.use("redis_config.txt").getInt("port");
        RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
        me.add(rp);

        // 非第一次使用 use加载的配置，也可以先得到一个Prop对象，再通过该对象来获取值
        Prop p = PropKit.use("db_config.txt");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user")…);
        me.add(dp);
      }
    }
        如上代码所示，PropKit可同时加载多个配置文件，第一个被加载的配置文件可以使用PorpKit.get(…)方法直接操作，非第一个被加载的配置文件则需要使用PropKit.use(…).get(…)来操作。

    PropKit 的使用并不限于在 YourJFinalConfig 中，可以在项目的任何地方使用。此外PropKit.use(…)方法在加载配置文件内容以后会将数据缓存在内存之中，可以通过PropKit.useless(…)将缓存的内容进行清除。
 */