package ch.hegarc.ig.odi.Bank.beans;

import ch.hegarc.ig.odi.Bank.business.Account;
import ch.hegarc.ig.odi.Bank.business.Customer;
import ch.hegarc.ig.odi.Bank.service.Services;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class DetailsBean {

    @Inject
    Services services;
    Customer customer;

    public Customer getCustomerEdit() {
        return customer;
    }

    public void setCustomerEdit(Customer customerEdit) {
        this.customer = customerEdit;
    }
    
    /**
     * Creates a new instance of DetailsBean
     */
    public DetailsBean() {
    }

    @PostConstruct
    public void init() {
       customer = services.getCustomerEdit();
       customer.setAccounts(services.getAccountsByCustomer(customer));
    }

    public String accountDetails(Account account) {
        services.setAccountEdit(account);
        return "accountDetails";
    }
}
