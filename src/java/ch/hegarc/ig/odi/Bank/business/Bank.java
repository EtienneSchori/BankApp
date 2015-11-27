/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.Bank.business;

import java.util.List;

/**
 *
 * @author Etienne
 */
public class Bank {
    private int number;
    private String name;
    private List<Account> accounts;
    private List<Customer> customers;

    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Account getAccountByNumber(String Number){
        int cusNumber;

        Account account = null;
        
        for(Customer cus : customers){
           cusNumber = cus.getNumber();
           if(cusNumber == number){
               account = cus.getAccountByNumber(Number);
           }
        }
        return account;
    }
    
    public Customer getCustomerByNumber(int number){
        int cusNumber;
        Customer customer = null;
        
        for(Customer cus : customers){
            cusNumber = cus.getNumber();
            if(cusNumber == number){
                customer = cus;
            }
        }
        return customer;
    }
    
    public void addCustomer(int number, String fn, String ln){
        Customer customer = null;
        
        customer.setFirstName(fn);
        customer.setNumber(number);
        customer.setLastName(ln);
        
        customers.add(customer);
    }
    
    public void addAccount(String number, String name, double rate, Customer customer){
        for(Customer cus : customers){
            if(cus.getNumber() == customer.getNumber()){
                cus.addAccount(number, name, rate);
            } 
        }
    }
}
