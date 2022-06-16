package com.spring.bookinventory.controller;
import com.spring.bookinventory.DAO.EmployeeRepository;
import com.spring.bookinventory.entity.Employee;
import com.spring.bookinventory.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    @GetMapping("/")
//    public ModelAndView home(){
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("employees", employeeRepository.findAll());
//        return mv;
//    }

//    @GetMapping("/")
//    public String viewHomePage(Model model){
//        model.addAttribute("employees",employeeRepository.findAll());
//        return "home.html";
//    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping(path ="/addEmployee", consumes="application/json")
    public Employee saveEmployee(@ModelAttribute("employee") Employee employee){
        return employeeRepository.save(employee);
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }


    @GetMapping("/delete/{emp_id}")
    public String deleteEmployee(@PathVariable Integer emp_id){
        Employee employee = employeeRepository.findById(emp_id);
        if(employee == null) {
            return "Employee doesn't exist";
        }
        employeeRepository.deleteById(emp_id);
        return "Entity deleted successfully";
    }

    @PutMapping("/update")
    public Employee updateEmployee( Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/mostBoughtBook")
    public List<Sales> mostBoughtBook(){
        return employeeRepository.findMostBoughtBook();
    }

}
