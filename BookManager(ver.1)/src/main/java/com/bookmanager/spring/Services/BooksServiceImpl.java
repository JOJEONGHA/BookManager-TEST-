package com.bookmanager.spring.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookmanager.spring.EntityForm.Books;
import com.bookmanager.spring.Repositories.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService{
	private BooksRepository booksRepository;
	
	@Autowired
	public void setBooksServiceImpl(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	public List<Books> listAll(){
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

	@Override
	public Books getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
