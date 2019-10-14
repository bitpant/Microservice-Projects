package io.assignment.books_catalogue.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Brijesh.Pant on 13-06-2019.
 */
@RestController
public class BookControler {
    @Autowired
    private  BookServices bookService;

    @RequestMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        Book u= bookService.getBookById(id);
        if(u==null){
            throw new BookNotFoundException("id- "+id);
        }
        return u;
    }

    @RequestMapping(method= RequestMethod.POST,value="/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        Book u= bookService.addBook(book);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(u.getBookId()).toUri();

        return ResponseEntity.created(location).build();

    }

   /* @RequestMapping(method=RequestMethod.PUT,value="/books/{id}")
    public String updateBook(@RequestBody Book book,@PathVariable String id){
        return bookService.updateBook(id);
    }*/

    @RequestMapping(method=RequestMethod.DELETE,value="/books/{id}")
    public Book deleteBook(@PathVariable int id){
        Book u= bookService.deleteBook(id);
        if(u==null){
            throw new BookNotFoundException("id- "+id);
        }
        return u;
    }
}
