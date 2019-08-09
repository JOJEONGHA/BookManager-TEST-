package com.bookmanager.spring.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookmanager.spring.Services.BooksService;

@Controller
public class BooksHandler {
	private BooksService booksService;
	
	@Autowired
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	
	@RequestMapping({"/","/books"})
	public String redirList() {
		return "redirect:/books/mainlist";
	}
		
	@RequestMapping("/books/mainlist")
	public String booksList(Model model) {
		// (name,value), Object(value) to used custom name(name) instead of original name
		model.addAttribute("books", booksService.listAll());
		return "books/Main_list";
	}
}
