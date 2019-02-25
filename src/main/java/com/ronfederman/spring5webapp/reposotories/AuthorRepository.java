package com.ronfederman.spring5webapp.reposotories;

import com.ronfederman.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
