package com.tianyi.system.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author : LiYong
 * @program : OJsonUtil
 * @description : OJsonUtil
 * @date : 2019/9/14 0:05
 */
@Component
public class OJsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 对象转字符串
     *
     * @param obj 对象
     * @return 字符串
     */
    public static String toString(Object obj) {

        if (Objects.isNull(obj)) {
            return "";
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }

        String s = null;
        try {
            s = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * json字符串转对象
     * 这个<T> T 可以传入任何类型的List
     * 参数T
     * 第一个 表示是泛型
     * 第二个 表示返回的是T类型的数据
     * 第三个 限制参数类型为T
     *
     * @param json   json字符串
     * @param tClass 参数类型
     * @param <T>    返回的泛型
     * @return 返回T
     */
    public static <T> T toBean(String json, Class<T> tClass) {

        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 这里传入的泛型指的是List<T>中的泛型T
     *
     * @param json json字符串
     * @param tClass 参数类型
     * @param <T> 泛型
     * @return 返回泛型为T的List
     */
    public static <T> List<T> toList(String json, Class<T> tClass) {

        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, tClass));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
