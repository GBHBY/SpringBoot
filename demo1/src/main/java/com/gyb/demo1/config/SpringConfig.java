package com.gyb.demo1.config;

import com.gyb.demo1.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author gb
 * @Date 2020/9/17 22:24
 * @Version 1.0
 * description:Spring配置类，SpringBoot推荐使用纯注解
 * @Configuration：指明当前类是个配置类，替代配置文件
 */

@Configuration
public class SpringConfig {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/9/17 22:27
     *
     * @param
     * @return Person
     * @Bean：将方法的返回值添加到容器中，默认的id就是方法名
     */
    @Bean
    public Person personConstruct() {
        System.out.println("存在person bean");
        return new Person();

    }


}
