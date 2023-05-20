package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getAllBook();


    Book updateBook(Book book, Integer bookId);

    Boolean isBookAvailable(Integer bookId);

    List<Book> activeBookOnly();

    void deleteBook(Integer bookId);

}



