package com.tianyi.trade.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/14 20:01
 */
public class JsonUtils {
    /**
     * 定义 jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 对象转为json
     * @param object 传入数据
     * @return String
     */
    public static String objectToJson(Object object){
        if(object == null){
            return "";
        }
        if(object instanceof String){
            return (String) object;
        }
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Json结果转对象
     * @param data Json结果
     * @param clazz 对象的类型
     * @param <T> 泛型
     * @return 对象
     */
    public static <T> T jsonToObject(String data, Class<T> clazz){
        try {
            return MAPPER.readValue(data, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Json转对象list
     * @param data Json结果
     * @param clazz 对象
     * @param <T> 泛型
     * @return 对象LISt
     */
    public static <T>List<T> jsonToList(String data, Class<T> clazz){
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return MAPPER.readValue(data, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


 }
