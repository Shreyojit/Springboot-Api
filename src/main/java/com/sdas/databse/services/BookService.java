package com.sdas.databse.services;

import com.sdas.databse.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn,BookEntity book);
}
