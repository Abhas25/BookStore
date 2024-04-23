package com.abhas.Book.Store.Repository;

import com.abhas.Book.Store.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {



}
