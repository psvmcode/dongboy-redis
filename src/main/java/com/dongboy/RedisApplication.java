package com.dongboy;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class RedisApplication {

    @Resource
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

//    @Resource(name = "forGXSZ", type = ThreadPoolTaskExecutor.class)
//    private ThreadPoolTaskExecutor gxszThreadPool;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

//    @Scheduled(cron = "*/3 * * * * ?")
//    public void sayHello() {
//        // 调用方法周期性执行
//        for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
//            System.out.println("当前轮第" + i + "次获取");
//            gxszThreadPool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    getHtmlFromGXSZ("http://gxsz.e21.cn/index.php?g=gxsz&m=news_list&a=newsdetail&id=48132");
////                    getHtmlFromGXSZ("http://223.75.52.70:8091/content/details190_546.html");
//                }
//            });
//        }
//    }
//
//    private void getHtmlFromGXSZ(String path) {
//        try {
//            //创建一个URL实例
//            URL url = new URL(path);
//            try {
//                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
//                InputStream is = url.openStream();
//                InputStreamReader isr = new InputStreamReader(is, "utf-8");
//                //为字符输入流添加缓冲
//                BufferedReader br = new BufferedReader(isr);
//                String data = br.readLine();//读取数据
//                while (data != null) {//循环读取数据
////                    System.out.println(data);//输出数据
//                    data = br.readLine();
//                }
//                br.close();
//                isr.close();
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

}
