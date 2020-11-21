package com.fickshare.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DefaultConfig {

    /*
        Injectable RestCLient bean
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*
        Injectable JSON DESER
     */
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper  objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return objectMapper;
    }

    /*
        Use by REST API Documentation
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("FlickShare Application API").description(
                        "These APIs are used by the FlickShare Application"));
    }
}
