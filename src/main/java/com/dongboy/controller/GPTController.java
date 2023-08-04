package com.dongboy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/5/3 14:11
 */
@RestController
@RequestMapping("gpt")
@Api(tags = "GPT测试")
public class GPTController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/test")
    @ResponseBody
    @ApiOperation(value = "测试gpt")
    public Object faceInfo(String context) {
        String apiURL = "http://43.131.38.107:8080/get_response";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("prompt", context);
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(requestParam, headers);
        String s = request.toString();
        ResponseEntity<String> entity2 = restTemplate.exchange(apiURL, HttpMethod.POST, request, String.class);
        String body = entity2.getBody();
        System.out.println("当前是");
        System.out.println(body);
        return body;
    }


}
