package com.firstapiexample.example.firstapiexample.customerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.firstapiexample.example.firstapiexample.customerRepository.CustomerRepository;
import com.firstapiexample.example.firstapiexample.model.Customer;
import com.mongodb.client.model.Field;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository  repository;

	public Customer createdata(Customer c) {
		return repository.save(c);
	}

	public Customer updatecompleterecord(Customer c) {
		return repository.save(c);
	}

	public void delpost(int id) {
		Optional<Customer> custo = repository.findById(id);
		if(custo.isPresent()) {
			repository.delete(custo.get());
		}else {
		   System.out.println("no record found "+id);
		}
	}

	public List<Customer> fetchallvalues() {
		List<Customer> ls = repository.findAll();
		return ls;
	}

	public Customer updateCustomerPartially(Customer c, int id, String firstName) {
		Customer customer = repository.findById(id).get();
		customer.setFirstname(firstName);
		return repository.save(customer);
	}

	public Customer updatelastname(Customer c, int id, String lastname) {
		Customer customer = repository.findById(id).get();
		customer.setLastname(lastname);
		return repository.save(customer);
	}

	public Customer updatedatapartially(int id, Map<Object, Object> fields) {
		Optional<Customer> customer = repository.findById(id);
		if(customer.isPresent()) {
			fields.forEach((key, value)->{
				java.lang.reflect.Field field = ReflectionUtils.findRequiredField(Customer.class, (String)key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, customer.get(), value);
			});	
			return repository.save(customer.get());
		}
		return null;
	}
}
