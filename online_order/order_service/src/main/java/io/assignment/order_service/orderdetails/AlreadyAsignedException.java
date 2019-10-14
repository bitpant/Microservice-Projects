package io.assignment.order_service.orderdetails;

import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * Created by Brijesh.Pant on 18-06-2019.
 */
public class AlreadyAsignedException extends RuntimeException {

public AlreadyAsignedException(String msg){
    super(msg);
}
}
