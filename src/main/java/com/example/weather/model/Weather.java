package com.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String city;
    @NonNull
    private double temperature;

    public Weather(@NonNull String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }
}
