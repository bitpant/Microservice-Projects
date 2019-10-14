package io.assignment.order_service.orderdetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue
    private int bookId;
    @Size(min = 3)
    private String bookName;
    private String bookDescriptions;
    private int price;
    public Book() {
         }

    public Book(int bookId, String bookName, String bookDescriptions, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescriptions = bookDescriptions;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescriptions() {
        return bookDescriptions;
    }

    public void setBookDescriptions(String bookDescriptions) {
        this.bookDescriptions = bookDescriptions;
    }
}
