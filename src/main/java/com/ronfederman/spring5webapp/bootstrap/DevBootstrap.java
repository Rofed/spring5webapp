package com.ronfederman.spring5webapp.bootstrap;

import com.ronfederman.spring5webapp.model.Author;
import com.ronfederman.spring5webapp.model.Book;
import com.ronfederman.spring5webapp.reposotories.AuthorRepository;
import com.ronfederman.spring5webapp.reposotories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author jk = new Author("JK","Rowling");
        Book book = new Book("Harry Potter","1234","some publisher");
        jk.getBooks().add(book);
        book.getAuthors().add(jk);

        authorRepository.save(jk);
        bookRepository.save(book);

        Author king = new Author("Stephen","King");
        Book shining = new Book("The Shining","4352", "Another publisher");
        king.getBooks().add(shining);

        authorRepository.save(king);
        bookRepository.save(shining);
    }
}
