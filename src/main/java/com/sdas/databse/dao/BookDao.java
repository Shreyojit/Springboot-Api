package com.sdas.databse.dao;

import com.sdas.databse.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}