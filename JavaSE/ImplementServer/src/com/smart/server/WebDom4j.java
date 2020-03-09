package com.smart.server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Smart-T
 * 解析XML
 *
 */
public class WebDom4j {

    private List<Entity> entityList; //用于存储N多Entity，而每个Entity都是servlet-name与servlet-class

    private List<Mapping> mappingList; //用于存储N多Mapping，而每个Mapping都是servlet-name与N多url-pattern

    public WebDom4j() {
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }


    //获取Document对象
    public Document getDocument(){

        try {
            //1.创建SAXReader对象
            SAXReader reader = new SAXReader();
            //2.调用read方法
            return reader.read(new File("ImplementServer/src/WEB_INF/web.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void parse(Document document){
        //1.获取根元素
        Element root = document.getRootElement();//web-app
        //2.获取servlet子元素
        for (Iterator<Element> ite = root.elementIterator("servlet");ite.hasNext();){
            Element subElement = ite.next();//得到每一个Servlet
            //创建一个实体类
            Entity ent = new Entity();//用于存储servlet-name与servlet-class
            for (Iterator<Element> subIte=subElement.elementIterator();subIte.hasNext();){
                Element ele = subIte.next();//可能是servlet-name，也可能是servlet-class
                if ("servlet-name".equals(ele.getName())){
                    ent.setName(ele.getText());//给实体类赋值
                }else if ("servlet-class".equals(ele.getName())){
                    ent.setClazz(ele.getText());
                }
            }
            //将Entity添加到集合中
            entityList.add(ent);
        }
        //test
        /*for (Entity entity:entityList){
            System.out.println(entity.getName() +"--->" + entity.getClazz());
        }*/

        //解析Mapping
        for (Iterator<Element> ite=root.elementIterator("servlet-mapping");ite.hasNext();){
            Element subEle = ite.next();//得到servlet-Mapping
            //创建Mapping类的对象
            Mapping mapping = new Mapping();
            //解析servlet-mapping下的子元素
            for (Iterator<Element> subIte = subEle.elementIterator();subIte.hasNext();){
                Element element = subIte.next();
                if ("servlet-name".equals(element.getName())){
                    mapping.setName(element.getText());
                }else if ("url-pattern".equals(element.getName())){
                    //获取集合对象，调用集合对象的添加方法，添加元素

                    mapping.getUrlPattern().add(element.getText());
                }
            }

            //Mapping添加到集合中
            mappingList.add(mapping);

        }

        //测试
        /*for (Mapping m : mappingList){
            System.out.println(m.getUrlPattern());
        }*/
    }
    //Web
   /* public static void main(String[] args) {
        WebDom4j webDom4j = new WebDom4j();
        webDom4j.parse(webDom4j.getDocument());
    }*/

}
