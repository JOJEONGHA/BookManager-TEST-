package com.bookmanager.spring.Service;

import java.util.List;

import com.bookmanager.spring.vo.Pieces;

public interface BookService {
	String listAll() throws Exception;
	String selectOne(Integer booknum);
	void updatePeice(String json);
	void createPeice(String json) throws Exception;
	void deletePiece(Integer booknum);
}
