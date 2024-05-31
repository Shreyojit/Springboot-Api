package com.sdas.databse.services;

import com.sdas.databse.domain.entities.AuthorEntity;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    AuthorEntity save(AuthorEntity authorEntity);
}
