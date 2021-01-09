package com.jy.springboot;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * tomcat在启动的时候会去找spring-web 下面的META-INF下面的services下面的
 * org.springframework.web.SpringServletContainerInitializer这样的一个文件，
 * 找到之后意味着当前这个spring作为web项目能够直接进行自己的加载工作。
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-01-09 10:54
 */
public class JyWebApplicationInitializer implements WebApplicationInitializer {

    /**
     * 这里和tomcat产生了联系
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //初始化spring容器- 注解替换xml中的bean配置
        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.register(JyAppConfig.class);
        configWebApplicationContext.setServletContext(servletContext);
        configWebApplicationContext.refresh();

        //初始化DispatcherServlet
        //创建容器，父子容器关系
        DispatcherServlet servlet = new DispatcherServlet(configWebApplicationContext);
        //针对请求的拦截
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
