package com.firstapiexample.example.firstapiexample.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.firstapiexample.example.firstapiexample.customerService.CustomerService;
import com.firstapiexample.example.firstapiexample.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@PostMapping("/post")
	public ResponseEntity<Customer> createdata(@RequestBody Customer c) {
		return new ResponseEntity<Customer>(customerservice.createdata(c), HttpStatus.ACCEPTED);

	}

	@PutMapping("/put")
	public ResponseEntity<Customer> updatecompleterecord(@RequestBody Customer c) {
		return new ResponseEntity<Customer>(customerservice.updatecompleterecord(c), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/patchfirst/{id}/{firstname}")
	public ResponseEntity<Customer> updateFirstname(@RequestBody Customer c, @PathVariable int id,
			@PathVariable String firstname) {
		return new ResponseEntity<Customer>(customerservice.updateCustomerPartially(c, id, firstname),
				HttpStatus.ACCEPTED);
	}

	@PatchMapping("/patchlast/{id}/{lastname}")
	public ResponseEntity<Customer> updatelastname(@RequestBody Customer c, @PathVariable int id,
			@PathVariable String lastname) {
		return new ResponseEntity<Customer>(customerservice.updatelastname(c, id, lastname), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Customer> updatedatapartially(@PathVariable int id,@RequestBody Map<Object, Object> fields) {
		return new ResponseEntity<Customer>(customerservice.updatedatapartially(id, fields), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/del/{id}")
	public void delpost(@PathVariable int id) {
		customerservice.delpost(id);
	}

	@GetMapping("/get")
	public List<Customer> getallvalues() {
		return customerservice.fetchallvalues();
	}
}
