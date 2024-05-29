package com.sdas.databse.repositories;

import com.sdas.databse.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
}
