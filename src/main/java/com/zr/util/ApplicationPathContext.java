package com.zr.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.*;

public class ApplicationPathContext implements MyFactory {
    //存储解析的bean列表
    List<MyBean> Beanlist=new ArrayList<>();
    //将Element对象的id,clazz值赋值给Map
    Map<String, Object> beanMap = new HashMap<>();

    public ApplicationPathContext(String filename) {
        //调用构造器的时候调用Context类的方法
        this.parseXml(filename);
        this.instanceBean();
    }

    private void instanceBean() {
        if (Beanlist != null && Beanlist.size() > 0) {
            Iterator<MyBean> iterator = Beanlist.iterator();
            while (iterator.hasNext()) {
                try {
                    MyBean next = iterator.next();
                    String id = next.getId();
                    String clazz = next.getClazz();
                    System.out.println(id);
                    Object object = Class.forName(clazz).newInstance();
                    beanMap.put(id, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parseXml(String filename) {
        SAXReader saxReader = new SAXReader();
        URL url = this.getClass().getClassLoader().getResource(filename);
        Element rootElement = null;
        try {
            Document read = saxReader.read(url);
            rootElement = read.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Element> elements = rootElement.elements();
//        System.out.println(elements.size());
        if (elements != null && elements.size() > 0) {
            for (Element element : elements) {
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                Beanlist.add(new MyBean(id, clazz));
            }
        }

    }

    public Object getBean(String id) {
        Object o = beanMap.get(id);
        return o;
    }
}