package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;



@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeServiceImplementationTest {

    @Autowired
    private EmployeeServiceImplementation underTest;




    @BeforeAll
    public void setUp(){
        Employee test = new Employee("Harumi", "Testing", "harumi@testing.com", 56200.0);
        Employee test2 = new Employee("Jack", "Testing", "jack@testing.com", 54000.0);
        underTest.save(test);
        underTest.save(test2);
    }


    @Test
    void findAllTest() {
        List<Employee> result = underTest.findAll();
        System.out.println(result);
        assertThat(result, hasSize(2));
    }

    @Test
    void findById() {
        Employee result = underTest.findById(1);
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void findByEmailTest() {
        String email = "jack@testing.com";
        Employee result = underTest.findByEmail(email);
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void save() {
        String email = "testingnew@testing.com";
        Employee test3 = new Employee("Testing", "Testing", "testingnew@testing.com", 56200.0);
        underTest.save(test3);
        Employee result = underTest.findByEmail(email);
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void deleteByIdTest() {
        Integer id = 2;
        underTest.deleteById(id);
        assertThat(underTest.findAll(), hasSize(1));
    }
}