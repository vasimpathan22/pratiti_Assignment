package com.demo.controller;

import com.demo.dto.BookDTO;
import com.demo.entity.BookEntity;
import com.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/hello")
    public String hello(){
        return "API_Working Fine";
    }

    @PostMapping("/addBook")
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDto){
        return bookService.createBook(bookDto);
    }

    @GetMapping("/getBookById/{bookId}")
    public Optional<BookEntity> getBookById(@PathVariable Integer bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("getAllBooks")
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("deleteBookById/{bookId}")
    public String deleteBook(@PathVariable Integer bookId){
        return bookService.deleteBook(bookId);
    }

    @PutMapping("/updateBook")
    public String updateBook(@RequestBody BookDTO bookDto){
        return bookService.updateBook(bookDto);
    }

    @GetMapping("/getBooksByTitle/{title}")
    public List<BookEntity> getBooksByTitle(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }

}
