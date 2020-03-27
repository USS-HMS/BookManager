package com.blhx.book_managers.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
}
