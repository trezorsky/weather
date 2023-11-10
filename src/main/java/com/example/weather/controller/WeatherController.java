package com.example.weather.controller;

import com.example.weather.model.Main;
import com.example.weather.model.Root;
import com.example.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableScheduling
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;
    @Value("${url.weather}")
    private String urlWeather;

    @Cacheable(value = "weatherCache", key = "#lat + '_' + #lon")
    @GetMapping
    public Main getWeather(@RequestParam String lat, @RequestParam String lon) {
        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s",
                urlWeather, lat, lon, appId);
        return restTemplate.getForObject(request, Root.class).getMain();
    }

    @Scheduled(fixedDelay = 60000)
    @CacheEvict(value = "weatherCache", key = "#lat + '_' + #lon", cacheManager = "cacheManager", allEntries = true)
    public void evictCache() {}

}
