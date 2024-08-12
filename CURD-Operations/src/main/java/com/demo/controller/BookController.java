package com.demo.controller;

import com.demo.dto.BookDTO;
import com.demo.entity.BookEntity;
import com.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/hello")
    public String hello(){
        return "API_Working Fine";
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> createBook(@Valid @RequestBody BookDTO bookDto , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation Failed");
        }
        bookService.createBook(bookDto);

        return ResponseEntity.status(HttpStatus.OK).body("Book Saved");
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
    public ResponseEntity<String> updateBook(@RequestBody BookDTO bookDto){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookDto));
    }

    @GetMapping("/getBooksByTitle/{title}")
    public List<BookEntity> getBooksByTitle(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }

}
