package com.gyb.springbootcrud;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

@SpringBootTest
class SpringbootCrudApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        String text = "Fri Apr 24 19:00:58 CST 2015";
        DateFormat formate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formate2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        Date date = formate2.parse(text);
        System.out.println(date);



    }


}
