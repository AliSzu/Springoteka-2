package Pracownia.Projekt.Spring.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi30Configuration {
    @Bean
    public OpenAPI customizeOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Springoteka")
                        .description("The REST API for the Springoteka application.")
                        .version("1.0.0"));

    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        String[] paths = { "/api/**" }; // Set your desired API paths here
        return GroupedOpenApi.builder().group("api").pathsToMatch(paths).build();
    }


}
