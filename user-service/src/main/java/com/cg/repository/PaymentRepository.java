package com.cg.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.Payment;



@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}