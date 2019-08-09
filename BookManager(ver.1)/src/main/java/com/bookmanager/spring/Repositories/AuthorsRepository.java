package com.bookmanager.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.bookmanager.spring.EntityForm.Authors;

public interface AuthorsRepository extends CrudRepository<Authors,Integer> {

}

