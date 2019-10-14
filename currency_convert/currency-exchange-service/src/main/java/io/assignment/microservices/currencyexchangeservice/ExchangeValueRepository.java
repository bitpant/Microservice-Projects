package io.assignment.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brijesh.Pant on 14-06-2019.
 */
public interface ExchangeValueRepository  extends
        JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
