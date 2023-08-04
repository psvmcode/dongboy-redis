package com.dongboy.common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dong boy
 * @date 2022年09月13日 13:31
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //控制器位置
                .apis(RequestHandlerSelectors.basePackage("com.dongboy.controller"))
                .paths(PathSelectors.any())  //表示扫描所有路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("redis")    //文档的标题，可自定义
                .description("swagger-bootstrap-ui")     //测试的接口文档，可自定义
                .termsOfServiceUrl("http://localhost:8080/")   //
                .contact("1084351114@qq.com")  //联系人信息，可自定义
                .version("1.0")   //版本信息，可自定义
                .build();
    }

}
