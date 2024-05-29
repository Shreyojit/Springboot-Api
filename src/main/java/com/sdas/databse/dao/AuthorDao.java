package com.sdas.databse.dao;

import com.sdas.databse.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);


    Optional<Author> findOne(long l);
}
