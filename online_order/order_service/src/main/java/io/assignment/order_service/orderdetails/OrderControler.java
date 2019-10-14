package io.assignment.order_service.orderdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Brijesh.Pant on 17-06-2019.
 */
@RestController
public class OrderControler {
    private int totalprice=0;
    @Autowired
    private OrderBean orderdetails;
    @GetMapping("/orderservice/books/{booklist}/user/{userid}")
    public Orders orderBooks(@PathVariable  int booklist, @PathVariable int userid) {
        Orders order =new Orders();
         /*int id=0;
            Map<Integer, Integer> uriVariables = new HashMap<>();
            uriVariables.put(id,booklist);*/
        for (Orders o:orderdetails.findAll()){
            if(o.getBooksid()==booklist)
                       throw new AlreadyAsignedException("Book "+booklist +"is already allocated to other user.");
            }


        ResponseEntity<User> responseEntity2 = new RestTemplate().getForEntity(
                "http://localhost:8095/users/"+userid, User.class);


            ResponseEntity<Book> responseEntity = new RestTemplate().getForEntity(
                    "http://localhost:8096/books/"+booklist, Book.class);

            Book response = responseEntity.getBody();
                totalprice+=response.getPrice();


        order.setBooksid(booklist);
        order.setUser(userid);
        order.setPrice(totalprice);
        orderdetails.save(order);
        totalprice=0;
        return new Orders(order.getOrderNumber(), order.getUser(),order.getBooksid(),order.getPrice());

    }

}
