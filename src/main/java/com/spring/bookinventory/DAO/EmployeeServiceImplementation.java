package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Employee;
import com.spring.bookinventory.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;


import java.util.List;

@Repository
public class EmployeeServiceImplementation implements EmployeeRepository{

    EntityManager entityManager;

    @Autowired
    public EmployeeServiceImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where(cb.equal(employee.get("employeeId"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Employee save(Employee newEmployee) {
        entityManager.persist(newEmployee);
        return newEmployee;
    }

    @Override
    public String deleteById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> employee = delete.from(Employee.class);
        delete.where(cb.equal(employee.get("employeeId"), id));
        entityManager.createQuery(delete).executeUpdate();

        return "{\"message\" : \"Entity deleted successfully\"}";
    }

    @Override
    public Employee findByEmail(String email) {
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where(cb.equal(employee.get("email"), email));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Sales> findMostBoughtBook() {
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sales> query = cb.createQuery(Sales.class);
        Root<Sales> salesTable = query.from(Sales.class);
        Join<Object, Object> salesAndBook = salesTable.join("book");
        query.select(salesAndBook.get("bookName"))
                .where(cb.like(salesAndBook.get("genre"),"Software Architecture"))
                .groupBy(salesAndBook.get("bookId"))
                .orderBy(cb.desc(cb.count(query.from(Sales.class))));

        return entityManager.createQuery(query).getResultList();
    }
}
