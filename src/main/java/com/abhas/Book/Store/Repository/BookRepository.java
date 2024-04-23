package com.abhas.Book.Store.Repository;

import com.abhas.Book.Store.Entity.Book;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {



}
