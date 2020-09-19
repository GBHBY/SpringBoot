package com.gyb.demo1;

import com.gyb.demo1.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private Person person;
    @Autowired
    private ApplicationContext ioc;


    /**
     * create by: gb
     * description: 测试是否存在personConstruct
     * create time: 2020/9/17 22:31
     */
    @Test
    void contextLoads() {
        System.out.println(ioc.containsBean("personConstruct"));

    }

    /**
     * create by: gb
     * description: 测试占位符配置属性，可以注入其他properties中的属性值
     * create time: 2020/9/17 22:49
     *
     * @param
     * @return
     */
    @Test
    void testPropertySource() {
        System.out.println(person);

    }


}
