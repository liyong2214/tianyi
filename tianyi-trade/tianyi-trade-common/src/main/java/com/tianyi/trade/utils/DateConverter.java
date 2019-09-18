package com.tianyi.trade.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Hens
 * @date : 2019/9/17 16:13
*/
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if(s == null || s.isEmpty()){
            return null;
        }
        SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        };
        for(SimpleDateFormat sdf :sdfs){
            try {
                return sdf.parse(s);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }
}
