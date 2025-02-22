package book.manager.service;

import book.manager.entity.Book;
import book.manager.entity.BorrowDetails;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    void deleteBook(int bid);
    void addBook(String title,String desc,double price);
    void borrowBook(int bid, int id);
    List<Book> getAllBookWithoutBorrow();
    List<Book> getAllBorrowedById(int id);
    void returnBook(int bid, int id);
    List<BorrowDetails> getBorrowDetailsList();
}
