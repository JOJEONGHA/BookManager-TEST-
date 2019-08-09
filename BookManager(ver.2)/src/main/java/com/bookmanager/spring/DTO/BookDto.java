package com.bookmanager.spring.DTO;

import java.util.List;

import com.bookmanager.spring.vo.Pieces;

public interface BookDto {
	void printList(List<Pieces> pList);
}
