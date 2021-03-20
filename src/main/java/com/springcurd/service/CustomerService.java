package com.springcurd.service;

import java.util.List;

import com.springcurd.entity.Customer;

public interface CustomerService {

public 	List<Customer> getCustomers();
public void saveCustomer(Customer customer);
public Customer getCustomer(int cid);
public void deleteCustomer(int cid);
	
}
