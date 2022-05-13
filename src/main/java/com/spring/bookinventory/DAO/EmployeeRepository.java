package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Employee;
import com.spring.bookinventory.entity.Sales;

import java.util.List;

public interface EmployeeRepository {
     List<Employee> findAll();
     Employee findById(Integer id);
     Employee save(Employee newEmployee);
     String deleteById(Integer id);
     Employee findByEmail(String email);

     List<Sales> findMostBoughtBook();
}
