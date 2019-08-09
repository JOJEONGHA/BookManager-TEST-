package com.bookmanager.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.bookmanager.spring.EntityForm.Books;

public interface BooksRepository extends CrudRepository<Books,Integer>{
}
	
