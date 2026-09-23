package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    public Book add(Book b) {
        if (repo.existsByIsbn(b.getIsbn()))
            throw new IllegalArgumentException("ISBN already exists");

        if (b.getQuantity() == null || b.getQuantity() < 0)
            throw new IllegalArgumentException("Quantity must be >= 0");

        b.setAvailableQuantity(b.getQuantity());

        return repo.save(b);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book get(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found: " + id));
    }

    public Book update(Long id, Book b) {
        Book old = get(id);

        old.setTitle(b.getTitle());
        old.setAuthor(b.getAuthor());
        old.setCategory(b.getCategory());

        if (b.getQuantity() != null) {
            int borrowed = old.getQuantity() - old.getAvailableQuantity();

            if (b.getQuantity() < borrowed)
                throw new IllegalArgumentException(
                        "Quantity cannot be less than borrowed copies"
                );

            old.setQuantity(b.getQuantity());
            old.setAvailableQuantity(b.getQuantity() - borrowed);
        }

        return repo.save(old);
    }

    public void delete(Long id) {
        repo.delete(get(id));
    }
}
