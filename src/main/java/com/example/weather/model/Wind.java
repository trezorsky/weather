package com.example.weather.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}
