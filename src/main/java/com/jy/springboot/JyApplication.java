package com.jy.springboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class JyApplication {

    //1.去掉xml, --spring bean配置，使用注解替换，web.xml中<bean>配置
    //2.不用手动将项目放入到tomcat内，  main方法直接启动tomcat, 内置tomcat
    //3.DispatcherServlet  -- new
    //4. ContextLoaderLister -- new Application 自己做
    public static void run() {

        try {
            Tomcat tomcat = new Tomcat();
            tomcat.start();
            tomcat.setPort(9090);
            //将当前项目放入tomcat中，第一个参数用来区分具体访问到哪个相聚，第二个参数当前项目的地址
            tomcat.addWebapp("jy","F://soundCode//open_source//jy-springboot");
            tomcat.getServer().await();
        } catch (ServletException | LifecycleException e) {
            e.printStackTrace();
        }
    }
}
