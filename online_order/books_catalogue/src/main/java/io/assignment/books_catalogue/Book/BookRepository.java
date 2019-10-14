package io.assignment.books_catalogue.Book;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
public interface BookRepository extends CrudRepository<Book,Integer> {
}
