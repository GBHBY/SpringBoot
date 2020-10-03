package com.gyb.springbootcrud.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author gb
 * @Date 2020/9/26 14:20
 * @Version 1.0
 * description:解决国际化。SpringMVC默认是根据请求头来获取区域信息，请求头中的区域信息是根据浏览器设置的语言决定的。我们可以自定义获取区域信息的方式，
 */

public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        /*  <a class="btn btn-sm" th:href="@{/index.html(l = 'zh_CN')}">中文</a>
            <a class="btn btn-sm" th:href="@{/index.html(l = 'en_US')}">English</a>
             参数中l的值就是区域信息，通过获取区域信息*/
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
