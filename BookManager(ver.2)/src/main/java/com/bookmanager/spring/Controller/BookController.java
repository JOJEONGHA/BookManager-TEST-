package com.bookmanager.spring.Controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.spring.Service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;

	// All List Load	
	@RequestMapping("/list")
	public String bookList() throws Exception {
		return service.listAll();
	}

	// (필요) 클릭 시 해당 booknum의 주소 /{id}

	// More information about one
	@RequestMapping("/booknum={booknum}") 
	public String bookinf(@PathVariable Integer booknum) throws Exception{
		return service.selectOne(booknum);
	}

	// Update book information
	@RequestMapping("/update")
	public String bookUpdate(String json) { // ReadManager
		return null;
	}

	// Delete book information
	@RequestMapping("/booknum={booknum}/-")
//	@PutMapping("/booknum={booknum}")
	public String bookDelete(@PathVariable Integer booknum) throws Exception { // ReadManager
		service.deletePiece(booknum);
		return "http://localhost:8080/";
	}

	// create new book
	@RequestMapping("/create")
	public String bookCreate() { // ReadManager
		return null;
	}

	// Json -> Object
	// List<MyClass> myObjects = mapper.readValue(p, new
	// TypeReference<List<Pieces>>() {});
}
