package com.bookmanager.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmanager.spring.vo.Pieces;

public interface BookRepository extends JpaRepository<Pieces,Integer>{

}
