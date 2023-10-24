package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private String imageName;
    public User(final String name, final int age, String imageName) {
        this.name = name;
        this.age = age;
        this.imageName = imageName;
    }
}
