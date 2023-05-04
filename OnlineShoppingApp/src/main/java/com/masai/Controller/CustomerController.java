package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.CustomerService;
import com.masai.model.Customer;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customerSave")
	public ResponseEntity<Customer> saveCustmerHandller(@Valid @RequestBody Customer customer) {
		Customer customer2 = customerService.saveCustomer(customer);
		return new ResponseEntity<>(customer2, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customerDelete")
	public ResponseEntity<Customer> deleteCustmerHandller(@Valid @RequestBody Customer customer) {
		Customer customer2 = customerService.deleteCustomer(customer.getCustomerId());
		return new ResponseEntity<>(customer2, HttpStatus.OK);
	}

	@PutMapping("/customerUpdate")
	public ResponseEntity<Customer> updateCustmerHandller(@Valid @RequestBody Customer customer) {
		Customer customer2 = customerService.updateCustomer(customer);
		return new ResponseEntity<>(customer2, HttpStatus.OK);
	}
	
}
