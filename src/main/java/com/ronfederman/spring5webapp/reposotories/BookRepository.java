package com.ronfederman.spring5webapp.reposotories;

import com.ronfederman.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
