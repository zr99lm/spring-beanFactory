import com.zr.dao.UserDao;
import com.zr.service.StudentService;
import com.zr.service.TypeService;
import com.zr.service.UserService;
import com.zr.util.ApplicationPathContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class test1 {
    //通过SAXReader解析获取class和id
    @Test
    public void test() throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SAXReader saxReader = new SAXReader();
        URL url = this.getClass().getClassLoader().getResource("applicationcontext.xml");
        Document read = saxReader.read(url);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String clazz = element.attributeValue("class");
            System.out.println(id + "+" + clazz);
        }
        Object o = Class.forName("com.zr.service.UserService").newInstance();
    }

    @Test
    public void test2() {
        //单个配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
        //多个配置文件
        ApplicationContext cc = new ClassPathXmlApplicationContext("config1.xml", "config2.xml");
        ApplicationContext ccMain = new ClassPathXmlApplicationContext("configMain.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.UserDaoMethod();
        System.out.println("-----------");
        UserDao userDao1 = (UserDao) cc.getBean("userDao");
        UserService userService1= (UserService) cc.getBean("userService");
        userDao1.UserDaoMethod();
        userService1.UserServiceMethod();
        System.out.println("-----------");
        UserDao userDao2 = (UserDao) ccMain.getBean("userDao");
        UserService userService2= (UserService) ccMain.getBean("userService");
        userDao2.UserDaoMethod();
        userService2.UserServiceMethod();
    }
    @Test
    public void testFactory(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("configFactory.xml");
        //静态工厂获取userDao对象
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.UserDaoMethod();
        //实例化工厂获取userDao对象
    }
    //set方式注入
    @Test
    public void testSET(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("configSet.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.test();
        System.out.println(studentService.toString());
    }
    //构造器方式注入
    @Test
    public void testCon(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config_constructor.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        System.out.println(studentService.toString());
    }
    //构造器方式注入的循环依赖异常


    //静态工厂注入,set注入的话定义typeDao
    // 静态工厂实例化 class定义静态工厂 和 factory-method静态工厂方法
    @Test
    public void testStaticFactory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config_factory_inject.xml");
        TypeService typeService = (TypeService) ac.getBean("typeService");
        typeService.test();
    }


    //实例化工厂注入
    @Test
    public void testInstanceFactory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("configInstanceFactory1.xml");
        TypeService typeService = (TypeService) ac.getBean("typeService");
        typeService.test();
    }
}
