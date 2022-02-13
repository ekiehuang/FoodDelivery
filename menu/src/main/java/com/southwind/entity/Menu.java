package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class Menu implements Serializable {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;
}
