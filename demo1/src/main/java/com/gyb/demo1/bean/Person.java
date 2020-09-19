package com.gyb.demo1.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author gb
 * @Date 2020/9/16 22:53
 * @Version 1.0
 * description:
 */
@Component
@PropertySource(value = {"classpath:person.properties", "classpath:device.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    private Device device;
    private String name;
    private int age;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "device=" + device +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
