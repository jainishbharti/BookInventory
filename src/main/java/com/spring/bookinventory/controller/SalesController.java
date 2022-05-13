package com.spring.bookinventory.controller;

import com.spring.bookinventory.DAO.SalesRepository;
import com.spring.bookinventory.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesController {

    @Autowired
    SalesRepository salesRepository;


    @PostMapping(path="/sale", consumes="application/json")
    public Sales add(@RequestBody Sales sale){
        salesRepository.save(sale);
        return sale;
    }

    @RequestMapping(path="/sales")
    public List<Sales> getSales(){
        return salesRepository.findAll();
    }

    @RequestMapping(path="/sale/{salesId}")
    public Optional<Sales> getSalesById(@PathVariable Integer salesId){
        return salesRepository.findById(salesId);
    }

    @PutMapping(path="/sale")
    public Sales saveOrUpdateSale(@RequestBody Sales sale){
        salesRepository.save(sale);
        return sale;
    }

    @DeleteMapping(path="/sale/{salesId}")
    public String deleteSale(@PathVariable Integer salesId){
        salesRepository.deleteById(salesId);
        return "{\"message\" : \"Entity deleted successfully\"}";
    }
}
