package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired private CustomerDao customerDao;
}
