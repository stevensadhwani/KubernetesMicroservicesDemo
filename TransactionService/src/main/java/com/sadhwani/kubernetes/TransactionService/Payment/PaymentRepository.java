package com.sadhwani.kubernetes.TransactionService.Payment;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource // exposes all of its CRUD operations as REST endpoints
public interface PaymentRepository {

    List<Payment> findByName(String name);
    Payment save(Payment payment);

}
