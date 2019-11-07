package com.tan.factory;

import java.beans.beancontext.BeanContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/*
 *是一个创建bean对象的工厂
 * Bean在计算机英语中，有可重用组件的含义
 * Javabean（用java语言编写的可重用组件）不等于实体类（Javabean>实体类）
 *
 * 他就是创建我们的service和dao对象的
 * 第一个： 需要一个配置文件来配置我们的service和dao
 * 配置文件内容（唯一标识=全限定类名（key-value））
 * 第二个：通过读取配置文件中配置内容，反射创建对象
 * 配置文件可以是xml和properties
 * */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;

    //选择使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件对象流
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /*
     *根据bean的名称获取bean对象
     *@param beanName
     * @return
     * */
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
