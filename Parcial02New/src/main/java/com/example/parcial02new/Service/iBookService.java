package com.example.parcial02new.Service;

import com.example.parcial02new.Domain.DTO.CreateBookDTO;
import com.example.parcial02new.Domain.DTO.UpdateBookDTO;
import com.example.parcial02new.Domain.Entity.Book;

import java.util.List;

public interface iBookService {
    Book createBook (CreateBookDTO dto);
    Book getBookById(Integer id);
    Book getBookByAuthor(String author);
    Book getBookByISBN(String isbn);
    Book getBookByLanguage(String language);
    Book getBookByGenre(String genre);
    List<Book> getAllBooks();
    Book updateBook(Integer id, UpdateBookDTO dto);
    void deleteBook(Integer id);
}