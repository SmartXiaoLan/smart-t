package cn.smart.javadoc;
//该类主要讲解JavaDoc中的一些标签。
/**
 * @author Smart-T
 * Power By 《Thinking In Java》
 * 1.介绍JavaDoc中常用的标签的作用及用法。
 *
 */
//:object/JavaDocTag.java
/**
 * @author Smart-T
 * @author www.smart.cn
 * @version 1.0
 */
public class JavaDocTag {

    /**
     *
     * @param args array of string arguments
     * @throws Exception exception throw
     */
    public static void main(String[] args) throws Exception{

    }
}
/*
 * 1.@see:引用其他类
 *      该标签允许用户引用其他类的文档。javadoc会在其生成的HTML文件中，通过该标签连接到其他文档。格式：
 *      @see classname
 *      @see fully-qualified-classname
 *      @see fully-qualified-classname#method-name
 *      上面的格式都会在生成的文档中加入具有“See Also”条目超链接，但是javadoc不保证其是否有效
 * 2.{@link package.clasname#member label}
 *      该标签与@see极其相似，只是它用于行内，且具有‘label’作为超链接文本而不用"See Also"
 * 3.{@docRoot}
 *      该标签产生到文档根目录的相对路径，用于文档树页面的显示超链接
 * 4.{@inheritDoc}
 *      该标签从当前这个类的最直接的基类中继承相关文档到当前文档注释中
 * 5.@version
 *      格式：@version version-information
 *      如果使用的-version标记。在生成的HTML文档中会特别提出版本信息
 *      version-information
 *      格式：@author author-information
 *      如果使用的-author标记。在生成的HTML文档中会特别提出作者信息
 *      author-information：这一看便知道你的名字他可能是电子邮件或者其他与作者相关的信息
 *      该标签可以使用多个以便列出所有作者信息，但是必须是连续。全部的作者信息会生成在同一段落。
 * 7.@since
 *      该标签允许你指定程序代码最早的使用版本。Java文档中看到它被用来指定所有的JDK版本情况
 * 8.@param
 *      该标签用于方法文档中。
 *      格式：@param parameter-name description
 *      parameter-name是方法参数列表中的标识符 ，description可以延续数行文本，终止于新的文档标签出现之前，
 *          可以使用任意个，大约每隔参数都有一个这样的标签。
 * 9.@return
 *      标签用于方法文档
 *      格式：@return description
 *      描述返回值，值信息。可以延续数行。
 * 10.@throws
 *      异常标签
 *      格式：@throws fully-qualified-class-name description
 *      fully-qualified-class-name:给出一个异常类的无歧义的名字，而该异常类在别处定义。
 * 11.@deprecated
 *      该标签用于指出一些旧特性已由改进的新特性所取代，建议用户不要再使用这个旧特性，因为再不久的将来可能会被删除的危险。
 *          如果使用一个标有该标签的方法，编译器会发出警告。该标签在JavaSE5中被@Deprecated注解所替代。
 */