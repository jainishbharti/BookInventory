package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Employee;
import com.spring.bookinventory.entity.Sales;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository {
     List<Employee> findAll();
     Employee findById(Integer id);
     @Transactional
     Employee save(Employee newEmployee);
     @Transactional
     void deleteById(Integer id);

     void deleteAll();
     Employee findByEmail(String email);

     List<Sales> findMostBoughtBook();
}
