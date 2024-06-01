package com.sdas.databse.controllers;

import com.sdas.databse.domain.dto.BookDto;
import com.sdas.databse.domain.entities.BookEntity;
import com.sdas.databse.mappers.Mapper;
import com.sdas.databse.services.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    public BookController(Mapper<BookEntity, BookDto> bookMapper,BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    private Mapper<BookEntity,BookDto> bookMapper;

    private BookService bookService;


    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto
            ){

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);

        BookEntity savedBookEntity = bookService.createBook(isbn,bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);
        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED );
    }

}
