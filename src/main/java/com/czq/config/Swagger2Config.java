package com.czq.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${spring.profiles.active}")
    private String env;

    @Value("${project.version}")
    private String projectVersion;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)//
                .select() //
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) //
                .paths(PathSelectors.any()) //
                .build() //
                .apiInfo(apiInfo()) //
                .globalOperationParameters(globalParameter()); //
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //
                .title("数学算法模型") //
                .description("environment: " + env) //
                .version(projectVersion) //
                .build();
    }

    private List<Parameter> globalParameter() {
        List<Parameter> globalParams = new ArrayList<Parameter>();
//        Parameter headerToken = new ParameterBuilder() //
//                .name("Token") //
//                .description("登录用户的临时凭证") //
//                .modelRef(new ModelRef("string")) //
//                .parameterType("header") //
//                .required(false) //
//                .build();
//        globalParams.add(headerToken);
        return globalParams;
    }

}
