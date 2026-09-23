package com.library.service;

import com.library.entity.Book;
import java.util.List;

public interface BookService {

    Book add(Book b);

    List<Book> getAll();

    Book get(Long id);

    Book update(Long id, Book b);

    void delete(Long id);
}
