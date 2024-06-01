package com.sdas.databse.services;

import com.sdas.databse.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    AuthorEntity save(AuthorEntity authorEntity);

     List<AuthorEntity> findAll();
}
