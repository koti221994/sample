package com.springcurd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcurd.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomers() {
		System.out.println(" customerDAOImpl starts");
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		System.out.println(" customerDAOImpl ends");
		
				
		// return the results		
		return customers;
	}
	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
		
	}
	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, cid);
		
		return customer;
	}
	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", cid);
		query.executeUpdate();
		
	}

}
