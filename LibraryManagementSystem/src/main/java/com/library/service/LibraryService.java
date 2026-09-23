package com.library.service;

import com.library.entity.BorrowRecord;
import java.util.List;

public interface LibraryService {

    BorrowRecord borrow(Long userId, Long bookId);

    BorrowRecord returnBook(Long recordId);

    List<BorrowRecord> byUser(Long userId);

    List<BorrowRecord> all();
}
