package com.ronfederman.spring5webapp.reposotories;

import com.ronfederman.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository  extends CrudRepository<Publisher,Long> {
}
