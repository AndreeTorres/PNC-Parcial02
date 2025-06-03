package com.example.parcial02new.Repository;

import com.example.parcial02new.Domain.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface iBookRepository extends iGenericRepository<Book, Integer>{
    Book findByIsbn(String isbn);
    Book findByTitle(String title);
    Book findByAuthor(String author);
    Book findByLanguage(String language);
    Book findByGenre(String genre);
}

