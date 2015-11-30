package ch.hegarc.ig.odi.Bank.beans;

import ch.hegarc.ig.odi.Bank.business.Customer;
import ch.hegarc.ig.odi.Bank.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class ListBean implements Serializable {

    @Inject
    Services services;
    private List<Customer> customers;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @PostConstruct
    public void init() {
        customers = new ArrayList<Customer>();
        customers = services.getCustomersList();
    }

    public String Details(Customer customer) {
        services.setCustomerEdit(customer);
        return "Details";
    }

}
