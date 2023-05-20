package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    public BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @PutMapping("update/{id}")
    public Book editBook(@RequestBody Book book, @PathVariable("id") Integer bookId) {
        return bookService.updateBook(book, bookId);
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<String> checkBookAvailability(@PathVariable("id") Integer bookId) {
        boolean isAvailable = bookService.isBookAvailable(bookId);
        if (isAvailable) {
            return ResponseEntity.ok("Book is available");
        } else {
            return ResponseEntity.ok("Book is not available");
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        List<Book> availableBooks = bookService.activeBookOnly();
        return ResponseEntity.ok(availableBooks);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") Integer bookId) {
        bookService.deleteBook(bookId);
    }
}
