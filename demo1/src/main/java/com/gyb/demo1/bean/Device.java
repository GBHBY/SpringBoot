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
@PropertySource("classpath:device.properties")
@ConfigurationProperties(prefix = "device")
public class Device {
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
