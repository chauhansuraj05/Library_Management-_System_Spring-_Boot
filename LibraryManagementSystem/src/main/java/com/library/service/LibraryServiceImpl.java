package com.library.service;

import com.library.entity.*;
import com.library.repository.*;
import com.library.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final UserRepository users;
    private final BookRepository books;
    private final BorrowRecordRepository records;

    public LibraryServiceImpl(
            UserRepository u,
            BookRepository b,
            BorrowRecordRepository r) {
        users = u;
        books = b;
        records = r;
    }

    public BorrowRecord borrow(Long userId, Long bookId) {
        User u = users.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Book b = books.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));

        if (b.getAvailableQuantity() <= 0)
            throw new IllegalArgumentException("Book is not available");

        Book current = b;
        current.setAvailableQuantity(current.getAvailableQuantity() - 1);
        books.save(current);

        BorrowRecord r = new BorrowRecord();
        r.setUser(u);
        r.setBook(current);
        r.setBorrowDate(LocalDate.now());
        r.setStatus(BorrowRecord.Status.BORROWED);

        return records.save(r);
    }

    public BorrowRecord returnBook(Long recordId) {
        BorrowRecord r = records.findById(recordId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Borrow record not found"));

        if (r.getStatus() == BorrowRecord.Status.RETURNED)
            throw new IllegalArgumentException("Book already returned");

        r.setStatus(BorrowRecord.Status.RETURNED);
        r.setReturnDate(LocalDate.now());

        Book b = r.getBook();
        b.setAvailableQuantity(b.getAvailableQuantity() + 1);
        books.save(b);

        return records.save(r);
    }

    public List<BorrowRecord> byUser(Long userId) {
        return records.findByUserId(userId);
    }

    public List<BorrowRecord> all() {
        return records.findAll();
    }
}
