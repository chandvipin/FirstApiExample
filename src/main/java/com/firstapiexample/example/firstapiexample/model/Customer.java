package com.firstapiexample.example.firstapiexample.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@EntityScan
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Customer")
public class Customer {

	@Id
	private int id;
	private String firstname;
	private String lastname;
	
}
