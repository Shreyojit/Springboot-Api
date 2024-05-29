package com.sdas.databse.dao.impl;

import com.sdas.databse.TestDataUtil;
import com.sdas.databse.dao.AuthorDao;
import com.sdas.databse.domain.Author;
import com.sdas.databse.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

    private AuthorDao authorDao;

    private BookDaoImpl underTest;
    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest,AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }
    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }



}
