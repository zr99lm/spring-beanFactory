import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class test1 {
    //通过SAXReader解析获取class和id
    @Test
    public void test() throws DocumentException {
        SAXReader saxReader=new SAXReader();
        URL url=this.getClass().getClassLoader().getResource("applicationcontext.xml");
        Document read = saxReader.read(url);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String clazz = element.attributeValue("class");
            System.out.println(id+"+"+clazz);
        }
    }
}
