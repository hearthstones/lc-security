package com.lc.security.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger、Knife4j配置
 *
 * @author luchao
 * @date 2021/11/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.lc.security.oauth.controller"))
                // 指定路径处理，PathSelectors.any() 代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置API信息
     *
     * @return API信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("security-oauth 接口文档")
                .description("security-oauth 接口文档")
                .contact(new Contact("luchao", "http://localhost:9001/doc.html", "1967768885@qq.com"))
                .version("v1.0")
                .build();
    }
}
