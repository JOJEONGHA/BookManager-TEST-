package com.bookmanager.spring.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanager.spring.Repository.BookRepository;
import com.bookmanager.spring.vo.Pieces;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookDtoImpl implements BookDto{
	@Autowired
	private BookRepository repository;

	@Override
	public void printList(List<Pieces> pList) {
		int size = pList.size();
	}
}
