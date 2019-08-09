package com.bookmanager.spring.Services;

import java.util.List;
import com.bookmanager.spring.EntityForm.Books;

public interface BooksService {	
	List<Books> listAll();
	Books getById(Integer id);
}
