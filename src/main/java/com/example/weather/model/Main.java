package com.example.weather.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Main {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
}
