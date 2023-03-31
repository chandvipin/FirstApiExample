package com.firstapiexample.example.firstapiexample.customerRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.firstapiexample.example.firstapiexample.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
