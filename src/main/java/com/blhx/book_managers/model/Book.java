package com.blhx.book_managers.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private String price;
}
