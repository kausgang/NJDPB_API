package gov.nj.treas.NJDPB_API.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiConfig(){

        return new OpenAPI()
                .info(
                        new Info()
                                .title("NJDPB Retired & Purchase API")
                                .description("SpringBoot API to extract information from MSSql database")
                );
    }
}
