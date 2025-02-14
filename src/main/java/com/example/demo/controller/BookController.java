package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book API", description = "書籍管理のためのAPI")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "全書籍の取得",
            description = "登録されている全ての書籍情報を取得します")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @Operation(summary = "書籍の新規登録",
            description = "新しい書籍を登録します")
    @PostMapping
    public ResponseEntity<Book> createBook(
            @Parameter(description = "登録する書籍情報") 
            @RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookRepository.save(book));
    }

    @Operation(summary = "書籍の取得",
            description = "指定されたIDの書籍情報を取得します")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(
            @Parameter(description = "書籍ID") 
            @PathVariable Long id) {
        return ResponseEntity.ok(
            bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Book not found with id: " + id
                ))
        );
    }

    @Operation(summary = "書籍の更新",
            description = "指定されたIDの書籍情報を更新します")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @Parameter(description = "書籍ID") 
            @PathVariable Long id,
            @Parameter(description = "更新する書籍情報") 
            @RequestBody Book book) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Book not found with id: " + id
            );
        }
        book.setId(id);
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @Operation(summary = "書籍の削除",
            description = "指定されたIDの書籍を削除します")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @Parameter(description = "書籍ID") 
            @PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Book not found with id: " + id
            );
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}