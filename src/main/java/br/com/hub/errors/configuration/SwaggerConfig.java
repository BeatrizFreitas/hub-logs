package br.com.hub.errors.configuration;

import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        final String swaggerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODU3NTQ2OTIsInVzZXJfbmFtZSI6ImJldHJpejExMjE1QGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIkFETUlOIl0sImp0aSI6IjUzYmQzOTE2LTE2ZTAtNDFlYS04Zjc1LTQ4ZjYyOWI0NTg1NSIsImNsaWVudF9pZCI6ImNsaWVudF9pZCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.oOMir13tqByhaSv2qQ12aohc8hG6gB84fPqpGMPDA2o";
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(singletonList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .hidden(true)
                                .defaultValue("Bearer " + swaggerToken)
                                .build()
                        )
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Central de Erros")
                .description("API para Aplicação e Logs de Central de Erros")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Squad 3", "https://www.codenation.dev", "squad3@gmail.com"))
                .build();
    }


}
