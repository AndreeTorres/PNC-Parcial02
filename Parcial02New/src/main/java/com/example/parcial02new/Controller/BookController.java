package com.example.parcial02new.Controller;

import com.example.parcial02new.Domain.DTO.CreateBookDTO;
import com.example.parcial02new.Domain.DTO.GenericResponse;
import com.example.parcial02new.Domain.DTO.UpdateBookDTO;
import com.example.parcial02new.Domain.Entity.Book;
import com.example.parcial02new.Service.iBookService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final iBookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody @Valid CreateBookDTO dto){
        Book createdBook = bookService.createBook(dto);
        return GenericResponse.builder()
                .message("Book created successfully")
                .data(createdBook)
                .status(HttpStatus.CREATED)
                .build()
                .buildResponse();
    }
    @GetMapping("get/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        return GenericResponse.builder()
                .message("Book retrieved successfully")
                .data(book)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }

    @GetMapping("get/author")
    public ResponseEntity<?> getBookByAuthor(@PathParam("author") String author) {
        Book book = bookService.getBookByAuthor(author);
        return GenericResponse.builder()
                .message("Book retrieved successfully")
                .data(book)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }

    @GetMapping("get/isbn")
    public ResponseEntity<?> getBookByIsbn(@PathParam("isbn") String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        return GenericResponse.builder()
                .message("Book retrieved successfully")
                .data(book)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }

    @GetMapping("get/language")
    public ResponseEntity<?> getBookByLanguage(@PathParam("language") String language) {
        Book book = bookService.getBookByLanguage(language);
        return GenericResponse.builder()
                .message("Book retrieved successfully")
                .data(book)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }

    @GetMapping("get/genre")
    public ResponseEntity<?> getBookByGenre(@PathParam("genre") String genre) {
        Book book = bookService.getBookByGenre(genre);
        return GenericResponse.builder()
                .message("Book retrieved successfully")
                .data(book)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody @Valid UpdateBookDTO dto) {
        Book updatedProduct = bookService.updateBook(id, dto);
        return GenericResponse.builder()
                .message("Product updated successfully")
                .data(updatedProduct)
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return GenericResponse.builder()
                .message("Book deleted successfully")
                .status(HttpStatus.NO_CONTENT)
                .build()
                .buildResponse();
    }

    @GetMapping("get/all")
    public ResponseEntity<?> getAllProducts() {
        return GenericResponse.builder()
                .message("Books retrieved successfully")
                .data(bookService.getAllBooks())
                .status(HttpStatus.OK)
                .build()
                .buildResponse();
    }



}
