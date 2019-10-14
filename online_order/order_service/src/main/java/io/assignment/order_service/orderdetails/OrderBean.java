package io.assignment.order_service.orderdetails;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Brijesh.Pant on 17-06-2019.
 */
public interface OrderBean extends CrudRepository<Orders,Integer> {
}
