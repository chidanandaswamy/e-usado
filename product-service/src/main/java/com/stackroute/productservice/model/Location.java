package com.stackroute.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String name;
    private Double[] coordinates;
}
