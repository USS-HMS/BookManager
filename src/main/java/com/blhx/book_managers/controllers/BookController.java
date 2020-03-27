package com.blhx.book_managers.controllers;

import com.blhx.book_managers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/index")
    public String bookList( Model model ){
        loadAllBooksView(model);
        return "book/books";
    }

    private void loadAllBooksView ( Model model ){
        model.addAttribute("books", bookService.getAllBook());
    }
}
