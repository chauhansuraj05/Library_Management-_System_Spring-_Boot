package com.library.controller;

import com.library.entity.BorrowRecord;
import com.library.service.LibraryService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @PostMapping("/borrow/user/{userId}/book/{bookId}")
    public ResponseEntity<BorrowRecord> borrow(
            @PathVariable Long userId,
            @PathVariable Long bookId) {
        return new ResponseEntity<>(
                service.borrow(userId, bookId),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/return/{recordId}")
    public BorrowRecord returnBook(@PathVariable Long recordId) {
        return service.returnBook(recordId);
    }

    @GetMapping("/user/{userId}")
    public List<BorrowRecord> byUser(@PathVariable Long userId) {
        return service.byUser(userId);
    }

    @GetMapping("/records")
    public List<BorrowRecord> all() {
        return service.all();
    }
}
