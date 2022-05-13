package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
