package com.ronfederman.spring5webapp.bootstrap;

import com.ronfederman.spring5webapp.model.Author;
import com.ronfederman.spring5webapp.model.Book;
import com.ronfederman.spring5webapp.model.Publisher;
import com.ronfederman.spring5webapp.reposotories.AuthorRepository;
import com.ronfederman.spring5webapp.reposotories.BookRepository;
import com.ronfederman.spring5webapp.reposotories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author jk = new Author("JK","Rowling");
        Publisher publisher = new Publisher("Some publisher","121 some street");
        publisherRepository.save(publisher);
        Book book = new Book("Harry Potter","1234",publisher);
        jk.getBooks().add(book);
        book.getAuthors().add(jk);

        authorRepository.save(jk);
        bookRepository.save(book);

        Author king = new Author("Stephen","King");
        Publisher publisher1 = new Publisher("Another publisher","3241 Another street");
        publisherRepository.save(publisher1);
        Book shining = new Book("The Shining","4352", publisher1);
        king.getBooks().add(shining);

        authorRepository.save(king);
        bookRepository.save(shining);
    }
}
