package com.blhx.book_managers.service;

import com.blhx.book_managers.dao.BookDAO;
import com.blhx.book_managers.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public List<Book> getAllBook(){
        return bookDAO.selectAll();
    }
    public  int addBook( Book book){
        return bookDAO.addBook(book);
    }


}
