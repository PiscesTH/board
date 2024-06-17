package com.th.board.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@OpenAPIDefinition(
//        info = @Info(
//                title = "나나빛 Ver. 2",
//                description = "3차 프로젝트 나나빛",
//                version = "2.0.0"),
//        security = @SecurityRequirement(name = "authorization")
//)
//@SecurityScheme(
//        type = SecuritySchemeType.HTTP,
//        name = "authorization",
//        in = SecuritySchemeIn.HEADER,
//        bearerFormat = "JWT",
//        scheme = "Bearer"
//)
//public class SwaggerConfiguration {
//
//}

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Board Ver.1")
                        .description("게시판 만들기")
                        .version("1.0.0")
                );
    }

}