package com.springcurd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcurd.dao.CustomerDAO;
import com.springcurd.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(cid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int cid) {
		 customerDAO.deleteCustomer(cid);
		
	}

}
