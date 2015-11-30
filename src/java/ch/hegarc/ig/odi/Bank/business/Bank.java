/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.Bank.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Etienne
 */
public class Bank {
    Collection<Account> accounts;
    //Collection<Customer> customers;
    Map<Integer, Customer> customers;
    private int number;
    private String name;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param number
     * @param name
     */
    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
        this.customers = new HashMap<Integer, Customer>();
        this.accounts = new ArrayList<>();
    }

    /**
     *
     * @param number
     */
    public Account getAccountByNumber(String number) {
        Account accountFinal = null;
        Iterator<Account> accountsIterator = accounts.iterator();
        while (accountsIterator.hasNext()) {
            Account accountTemp = accountsIterator.next();
            if (accountTemp.getNumber().equals(number)) {
                accountFinal = accountTemp;
            }
        }
        return accountFinal;
    }

    /**
     *
     * @param number
     */
    public Customer getCustomerByNumber(int number) {
        Customer customerFinal = null;
        for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
            if (entry.getValue().getNumber() == number) {
                customerFinal = entry.getValue();
            }
        }
        return customerFinal;
    }

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer addCustomer(int number, String firstName, String lastName) {
        Customer customer = new Customer(number, firstName, lastName);
        this.customers.put(number, customer);
        return customer;
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public void addAccount(String number, String name, double rate, Customer customer) {
        if (customers.containsValue(customer)) {
            accounts.add(new Account(number, name, rate, customer));
        }
    }

    public Map<Integer, Customer> getCustomers() {
        return this.customers;
    }

    public Collection<Account> getAccountsByCustomer(Customer customer) {
        Collection<Account> accountsByCustomer = new ArrayList<>();
        for (Account account : accounts) {
            if (account.customer.getNumber() == customer.getNumber()) {
                accountsByCustomer.add(account);
            }
        }
        return accountsByCustomer;
    }
}
