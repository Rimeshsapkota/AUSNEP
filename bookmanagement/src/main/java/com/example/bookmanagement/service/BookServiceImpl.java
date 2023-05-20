package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book, Integer bookId) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        if (existingBook != null) {
            book.setBookId(bookId);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public Boolean isBookAvailable(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return book != null;
    }

    @Override
    public List<Book> activeBookOnly() {
        return bookRepository.findByIsActive(true);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}

