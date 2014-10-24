package com.papa.wx.web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.papa.wx.web.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findById(long id);
	Customer findByUsername(String username);
	List<Customer> findAll();
	//List<Customer> findByCreattimeBetween(Date start, Date end);

}
