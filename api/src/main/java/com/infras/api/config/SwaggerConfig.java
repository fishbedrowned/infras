package com.infras.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * Created by zhaoheng on 2017/9/6.
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@Profile({"local"})
public class SwaggerConfig {

    public static final String SWAGGER_GROUP = "infras";

    @Bean
    public Docket newsApi() {
        List<ResponseMessage> responses = new ArrayList<>();
        responses.add(new ResponseMessageBuilder().code(400).message("请求参数错误")
            .responseModel(new ModelRef("JsonResult")).build());
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName(SWAGGER_GROUP)
            .apiInfo(apiInfo())
            .directModelSubstitute(OffsetDateTime.class, Long.class)
            .genericModelSubstitutes(Optional.class)
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, responses)
            .globalResponseMessage(RequestMethod.POST, responses)
            .globalResponseMessage(RequestMethod.PUT, responses)
            .globalResponseMessage(RequestMethod.DELETE, responses)
            .select()
            .apis(basePackage("com.infras.api.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("测试服务")
            .version("1.0")
            .build();
    }
}
