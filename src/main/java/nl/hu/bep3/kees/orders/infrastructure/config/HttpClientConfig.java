package nl.hu.bep3.kees.orders.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
    @Value("http://localhost:8081")
    private String rootPath;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
