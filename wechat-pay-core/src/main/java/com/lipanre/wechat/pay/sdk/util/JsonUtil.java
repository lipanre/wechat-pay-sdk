package com.lipanre.wechat.pay.sdk.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;

/**
 * {@code description}
 * json工具类
 *
 * <br>
 * {@code date} 2024/10/31 9:11
 */
public class JsonUtil {

    /**
     * jackson object-mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 注册所有序列化与反序列化模块
        objectMapper.findAndRegisterModules();

        objectMapper.registerModule(new JavaTimeModule());
        // 如果字段为空，则不进行序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // json中下划线转驼峰，对象转json时使用下划线
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // 反序列化如果字段不存在不报错
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 如果枚举值不存在，则返回null
        objectMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    /**
     * 将对象转为json字符串
     *
     * @param object 待转换的对象
     * @return 对象的json字符串表示
     * @param <T> 对象类型
     */
    @SneakyThrows
    public static <T> String toJson(T object) {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * 将字符串转换为目标类型的对象
     *
     * @param json 待转换的json字符串
     * @param clazz 目标类型
     * @return 目标类型对象
     * @param <T> 目标类型
     */
    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * 将字符串转换为目标类型的对象
     *
     * @param json 待转换的json字符串
     * @param typeReference 目标类型TypeReference对象
     * @return 目标类型对象
     * @param <T> 目标类型
     */
    @SneakyThrows
    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        return objectMapper.readValue(json, typeReference);
    }
}
