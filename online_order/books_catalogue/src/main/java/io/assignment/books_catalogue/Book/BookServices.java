package io.assignment.books_catalogue.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
@Component
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

   public List<Book> getAllBooks(){
        List<Book> bookList=new ArrayList<Book>();
        for(Book u:bookRepository.findAll())
            bookList.add(u);
        return bookList;
    }

    public Book addBook(Book book) {
        return  bookRepository.save(book);

    }

    public Book getBookById(int id) {
        List<Book> bookList=new ArrayList<Book>();
        for(Book u:bookRepository.findAll())
        {
            if(u.getBookId()==id)
                return u;
        }
        return null;
    }

    public Book deleteBook(int id) {
        for(Book u:bookRepository.findAll())
        {
            if(u.getBookId()==id) {
                bookRepository.delete(u);
                return u;
            }
        }
        return null;

    }


   /* public User getUserById(int id){
        for(userRepository.)
        return userRepository.f;
    }*/
}
