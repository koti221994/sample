package com.springcurd.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcurd.entity.Customer;
import com.springcurd.exceptionHandler.CustomerNotFound;
import com.springcurd.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/customers")
	public List<Customer> getcCustomers(){
		return customerService.getCustomers();

	}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer=customerService.getCustomer(customerId);
		if(customer==null) {
			throw new CustomerNotFound("customer is not found - "+customerId);	
		}
		return customer;	
	}
	@PostMapping("/customers")
	public Customer addcustomer(@RequestBody Customer customer){
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;

	}
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;

	}


	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer customer=customerService.getCustomer(customerId);
		if(customer==null) {
			throw new CustomerNotFound("customer id not found - "+customerId);
		}
		
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id "+customerId;



	}
}