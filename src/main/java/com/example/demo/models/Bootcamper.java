package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// POJO -> Plain old java object
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bootcamper {
    private String nombre;
    private double valor;
}
