package com.demo.service;


import com.demo.dto.BookDTO;
import com.demo.repository.BookRepository;
import com.demo.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public ModelMapper mapper;


    public BookDTO createBook(BookDTO bookDto){
        BookEntity book=mapper.map(bookDto,BookEntity.class);

        return mapper.map(bookRepository.save(book),BookDTO.class);
    }

    public Optional<BookEntity> getBookById(Integer id){
        return bookRepository.findById(id);

    }

    public List<BookDTO> getAllBooks(){
        List<BookEntity> bookEntities=bookRepository.findAll();

       return bookEntities.stream()
                .map(bookEntity->mapper.map(bookEntity,BookDTO.class))
                .collect(Collectors.toList());

    }

    public String deleteBook(Integer bookId){
        bookRepository.deleteById(bookId);
        return "Book Deleted Successfully";
    }

    public String updateBook(BookDTO bookDto){

        var isBookPresent=getBookById(bookDto.getBookId());
        if(isBookPresent.isEmpty()) return "can Not Found The Book";

        var presentBook=isBookPresent.get();
        presentBook.setBookName(bookDto.getBookName());
        presentBook.setBookPrize(bookDto.getBookPrize());
        presentBook.setBookAuthor(bookDto.getBookAuthor());
        bookRepository.save(presentBook);
        return "Book Updates SuccessFully";
    }

    public List<BookEntity> getBooksByTitle(String title){
        return bookRepository.getBooksByTitle(title);
    }


}
