package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.util.JsonUtil;
import com.lipanre.wechat.pay.sdk.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * http-service类
 *
 * @author lipanre
 */
@RequiredArgsConstructor
public class HttpService {

    /**
     * http-client对象
     */
    private final HttpClient httpClient;

    /**
     * 发起post请求
     *
     * @param url 请求url
     * @param body 请求体对象
     * @param clazz 响应类
     * @return 响应类对象
     * @param <T> 响应类类型
     */
    @SneakyThrows
    public <T> T post(String url, Object body, Class<T> clazz) {
        HttpPost post = new HttpPost(url);
        post.setEntity(getEntity(body));
        return request(clazz, post);
    }

    @SneakyThrows
    public <T> T get(String url, Object params, Class<T> clazz) {
        HttpGet get = new HttpGet(url);
        if (Objects.nonNull(params)) {
            URIBuilder uriBuilder = new URIBuilder(url);
            for (Field field : params.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                // 名称要转为下划线
                String underLineName = StrUtil.toUnderLine(field.getName());
                uriBuilder.addParameter(underLineName, field.get(params).toString());
            }
            get.setURI(uriBuilder.build());
        }
        return request(clazz, get);
    }

    /**
     * 发起http请求
     *
     * @param <T> 响应类型
     * @param clazz 响应类class
     * @param httpRequest 请求对象
     * @return 响应对象
     * @throws IOException 请求异常
     */
    private <T> T request(Class<T> clazz, HttpRequestBase httpRequest) throws IOException {
        HttpResponse response = httpClient.execute(httpRequest);
        return JsonUtil.fromJson(EntityUtils.toString(response.getEntity()), clazz);
    }

    /**
     * 创建一个http请求entity对象
     *
     * @param param 请求参数
     * @return http请求entity对象
     */
    private HttpEntity getEntity(Object param) {
        return new StringEntity(JsonUtil.toJson(param), StandardCharsets.UTF_8);
    }


}
