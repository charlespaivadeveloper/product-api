package br.com.grupomateus.product.api.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${springdoc.api-docs.path:/v3/api-docs}")
    private String apiDocsPath;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("product-service")
                .pathsToMatch("/produtos/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("API documentation for Product Service")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
