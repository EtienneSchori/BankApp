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
    
    public Account getAccountByNumber(String number){
        Account cible = null;
        Integer i = 0;
        while (cible == null & i < accounts.size()) {
            if (accounts.get(i).getNumber().equals(number)) {
                cible = accounts.get(i);
            }
        }
        return cible;
        
    }
    
    public Customer getCustomerByNumber (int number){
        Customer cible = null;
        Integer i = 0;
        while (cible == null & i < customers.size()) {
            if (customers.get(i).getNumber()==number) {
                cible = customers.get(i);
            }
        }
        return cible;
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
