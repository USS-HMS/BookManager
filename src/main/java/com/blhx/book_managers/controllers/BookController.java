package com.blhx.book_managers.controllers;

import com.blhx.book_managers.model.User;
import com.blhx.book_managers.service.BookService;
import com.blhx.book_managers.service.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private HostHolder hostHolder;
    @GetMapping("/index")
    public String bookList( Model model ){
        User host=hostHolder.getUser();
        if (host!=null){
            model.addAttribute("host",host);
        }
        loadAllBooksView(model);
        return "book/books";
    }

    private void loadAllBooksView ( Model model ){
        model.addAttribute("books", bookService.getAllBook());
    }
}
