 package com.bookmanager.spring.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.spring.Repository.BookRepository;
import com.bookmanager.spring.vo.BookInf;
import com.bookmanager.spring.vo.Pieces;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repository;

	@Override
	public String listAll() throws Exception {
		// List의 세부기능을 쪼개어 Dto에 할당하자.
		List<Pieces> pieces = new ArrayList<>();
		String BookJson = "[";
		pieces = repository.findAll();
		Long size = repository.count();
		for (int i = 0; i < size; i++) {
			BookJson += "{\"Booknum\":" + pieces.get(i).getBooknum() + "<br/>";
			BookJson += ",\"Title\":\"" + pieces.get(i).getBooks().getTitle() + "\"<br/>";
			BookJson += ",\"Publisher\":\"" + pieces.get(i).getBooks().getPublisher() + "\"<br/>";
			BookJson += ",\"Author\":\"" + pieces.get(i).getAuthors().getAuthorname() + "\"<br/>";
			BookJson += ",\"Summary\":\"" + pieces.get(i).getBooks().getSummary() + "\"}";
			if (i != size)
				BookJson += ",<br/>";
			else
				BookJson += "]<br/>";
		}

		return BookJson;
	}

	// 특정 booknum 를 가진 책의 정보 Json 추출
	@Override
	public String selectOne(Integer booknum) {
		List<Pieces> pieces = new ArrayList<>();
		List<Pieces> temp = new ArrayList<>();
		// search and input
		// 해당 책번호를 가진 책의 List 작성
		Long size = repository.count();
		temp = repository.findAll();
		Pieces tempP = null;
		int count = 0;
		for (int i = 0; i < size; i++) {
			tempP = temp.get(i);
			if (tempP.getBooknum() == booknum) {
				pieces.add(tempP);
				count++;
			}

		}
		// (임시, 1/2번 수행시 제거)작성된 List Json 형식으로 변환
		// (중복, 매개변수 count)
		String BookJson = "[";
		for (int i = 0; i < count; i++) {
			BookJson += "{\"Booknum\":" + pieces.get(i).getBooknum() + "<br/>";
			BookJson += ",\"Title\":\"" + pieces.get(i).getBooks().getTitle() + "\"<br/>";
			BookJson += ",\"Publisher\":\"" + pieces.get(i).getBooks().getPublisher() + "\"<br/>";
			BookJson += ",\"Author\":\"" + pieces.get(i).getAuthors().getAuthorname() + "\"<br/>";
			BookJson += ",\"Summary\":\"" + pieces.get(i).getBooks().getSummary() + "\"}";
			if (i != count)
				BookJson += ",<br/>";
			else
				BookJson += "]<br/>";
		}
		// 1.(복수가능 부분, authors 검색)
		// 2.해당 booknum 위치의 JSON 에 따로 저장

		// 해당 책번호를 가진 Book Information return
		return BookJson;
	}
	
	@Override
	public void deletePiece(Integer booknum) {
		// 해당 북number 가진 pieces 리스트를 취합
		List<Pieces> temp = new ArrayList<>();
		List<Pieces> pieces = new ArrayList<>();

		pieces = repository.findAll();
		int size = pieces.size();
		for (int i = 0; i < size; i++) {
			if (pieces.get(i).getBooknum() == booknum)
				temp.add(pieces.get(i));
		}
		repository.deleteAll(temp);

		// 이를 removeAll의 매개변수로 전달(booknum 취합정보)
		// repository.findAll().removeAll(temp);
		// repository.deleteAll(temp);
	}
	
	@Override
	public void updatePeice(String json) {
		// 임시 Pieces 생성
		// 해당 정보 임시 출력
		// 현재 적혀져 있는 정보 update
		// repository.findById(1).

	}

	@Override
	public void createPeice(String json) throws Exception{
		// string형식 json data input
		ObjectMapper mapper = new ObjectMapper();
		// string(json) -> object(List<Pieces>)
		BookInf newBook = mapper.readValue(json, BookInf.class);
		// one by one (X) -> JSON INPUT TYPE == join Pieces Type
		
		// Input into repository(DB) [* : random input]
		// Books : *booknum,title,publisher,summary
		// Authors : *authornum, authorname
		// Pieces : *authornum, *booknum
		Pieces tempP = new Pieces();
//		tempP.setPiecenum(piecenum);	//
//		tempP.setAuthornum(authornum);
//		tempP.setBooknum(booknum);	// 날짜??
//		tempP.getAuthors().setAuthorname(authorname);
////		tempP.getAuthors().setAuthornum(authornum);
////		tempP.getBooks().setBooknum(booknum);
//		tempP.getBooks().setPublisher(publisher);
//		tempP.getBooks().setSummary(summary);
//		tempP.getBooks().setTitle(title);
		
//		tempP.
//		repository.
	}

}
