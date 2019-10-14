package io.assignment.order_service.orderdetails;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Brijesh.Pant on 13-06-2019.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue
    private int orderNumber;
    private int user;
    private int booksid;
    private int price;

    public Orders(){


    }

    public Orders(int orderNumber, int user, int booksid, int price) {
        this.orderNumber = orderNumber;
        this.user = user;
        this.booksid = booksid;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int getBooksid() {
        return booksid;
    }

    public void setBooksid(int booksid) {
        this.booksid = booksid;
    }





    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }


}
