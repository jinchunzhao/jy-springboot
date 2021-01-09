package com.jy.springboot;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-01-09 11:28
 */
@ComponentScan("com.jy")
@EnableWebMvc
public class JyAppConfig implements WebMvcConfigurer {

    /**
     * 返回值内容格式的转换
     * @param converters 转换规则列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //添加json解析规则
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        converters.add(fastConverter);
    }
}
