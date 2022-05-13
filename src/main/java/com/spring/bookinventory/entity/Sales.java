package com.spring.bookinventory.entity;

import javax.persistence.*;

@Entity
public class Sales {

   @Id
    private Integer salesId;

   @OneToOne
   @JoinColumn(name="customer_id", referencedColumnName= "customerId")
    private Customer customer;

   @OneToOne
   @JoinColumn(name="book_id", referencedColumnName = "bookId")
    private Book book;

    public Sales() {
    }

    public Sales(Integer salesId, Customer customer, Book book) {
        this.salesId = salesId;
        this.customer = customer;
        this.book = book;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", customer=" + customer +
                ", book=" + book +
                '}';
    }
}
