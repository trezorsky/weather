package com.example.weather.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableCaching
public class AppConfiguration {

    @Bean
    public  RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("weatherCache");
    }

}
