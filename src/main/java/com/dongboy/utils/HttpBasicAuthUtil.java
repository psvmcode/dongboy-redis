//package com.dongboy.utils;
//
//import cn.hutool.http.HttpUtil;
//import com.alibaba.fastjson.JSON;
//import com.dongboy.entity.jidu.pojo.http.HttpBaseResponse;
//import com.dongboy.entity.jidu.pojo.http.HttpConfig;
//import springfox.documentation.spring.web.json.Json;
//
///**
// * @Author dongboy
// * @what time    2023/4/13 22:19
// */
//public class HttpBasicAuthUtil {
//    public static HttpBaseResponse invoke(Object request, String username, String password, String url) {
//        return invoke(JSON.toJSONString(request), username, password, url);
//    }
//
//    public static HttpBaseResponse invoke(String json, String username, String password, String url) {
//        HttpConfig httpConfig = new HttpConfig();
//        httpConfig.setContentType(HttpUtil.C);
//    }
//}
