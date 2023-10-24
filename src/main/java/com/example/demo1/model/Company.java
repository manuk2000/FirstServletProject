package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private int id ;
    private String name;
    private int fild;
    private User userID;

    public Company(final String name, final int fild) {
        this.name = name;
        this.fild = fild;
    }

    public Company(final String name, final int fild, final User userID) {
        this.name = name;
        this.fild = fild;
        this.userID = userID;
    }
}
