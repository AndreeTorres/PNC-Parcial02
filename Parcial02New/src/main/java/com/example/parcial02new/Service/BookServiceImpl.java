package com.example.parcial02new.Service;


import com.example.parcial02new.Domain.DTO.CreateBookDTO;
import com.example.parcial02new.Domain.DTO.UpdateBookDTO;
import com.example.parcial02new.Domain.Entity.Book;
import com.example.parcial02new.Repository.iBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements iBookService {

    private  final iBookRepository bookRepository;

    @Override
    public Book createBook(CreateBookDTO dto) {
            Book book = new Book();
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setIsbn(dto.getIsbn());
            book.setPublicationYear(dto.getPublicationYear());
            book.setLanguage(dto.getLanguage());
            book.setPages(dto.getPages());
            book.setGenre(dto.getGenre());
            return (Book) bookRepository.save(book);
        }


    @Override
    public Book getBookById(Integer id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository
                .findByAuthor(author);

    }

    @Override
    public Book getBookByISBN(String isbn) {
        return bookRepository
                .findByIsbn(isbn);
    }

    @Override
    public Book getBookByLanguage(String language) {
        return bookRepository
                .findByLanguage(language);
    }

    @Override
    public Book getBookByGenre(String genre) {
        return bookRepository
                .findByGenre(genre);
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Integer id, UpdateBookDTO dto) {
        Book existing = bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existing.setTitle(dto.getTitle());
        existing.setLanguage(dto.getLanguage());
        return bookRepository.save(existing);
    }


    @Override
    public void deleteBook(Integer id) {
        Book existing = bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        bookRepository.delete(existing);
    }
}
