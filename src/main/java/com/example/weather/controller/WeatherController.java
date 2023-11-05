package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping
    public Iterable<Weather> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Weather findById(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Weather with id " + id + " not found"));
    }

    @PostMapping
    public Weather save(@RequestBody Weather weather) {
        return repository.save(weather);
    }
}
