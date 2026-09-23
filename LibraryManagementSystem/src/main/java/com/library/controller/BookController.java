package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book b) {
        return new ResponseEntity<>(service.add(b), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book b) {
        return service.update(id, b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
