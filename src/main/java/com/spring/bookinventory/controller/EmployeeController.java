package com.spring.bookinventory.controller;
import com.spring.bookinventory.DAO.EmployeeRepository;
import com.spring.bookinventory.entity.Employee;
import com.spring.bookinventory.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String home(ModelAndView mv){
        mv.addObject("employees", employeeRepository.findAll());
        return "home";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(ModelAndView mv){
        Employee employee = new Employee();
        mv.addObject("employee", employee);
        return "employeeForm";
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/employeeUpdateForm/{id}")
    public String employeeUpdateForm(@PathVariable Integer id, ModelAndView mv){
        Employee employee = employeeRepository.findById(id);
        mv.addObject("employee", employee);
        return "updateEmployee";
    }


    @GetMapping("/delete/{emp_id}")
    public String deleteEmployee(@PathVariable Integer emp_id){
        Employee employee = employeeRepository.findById(emp_id);
        if(employee == null) {
            throw new RuntimeException("Employee doesn't exist");
        }
        employeeRepository.deleteById(emp_id);
        return "redirect:/";
    }

    @PutMapping("/update")
    public String updateEmployee( Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/mostBoughtBook")
    public List<Sales> mostBoughtBook(){
        return employeeRepository.findMostBoughtBook();
    }

}
