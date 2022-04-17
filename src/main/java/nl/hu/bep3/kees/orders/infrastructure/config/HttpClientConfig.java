package nl.hu.bep3.kees.orders.infrastructure.config;

import nl.hu.bep3.kees.orders.infrastructure.driven.storage.HttpStockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
    @Value("${http-client.root-path.stock}")
    private String roothPath;

    @Bean
    public HttpStockRepository httpStockRepository() { return new HttpStockRepository(roothPath, restTemplate()); }

    @Bean
    public RestTemplate restTemplate() { return new RestTemplate(); }
}
