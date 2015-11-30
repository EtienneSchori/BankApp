package ch.hegarc.ig.odi.Bank.beans;

import ch.hegarc.ig.odi.Bank.service.Services;
import java.io.Serializable;
import javax.inject.Inject;

public class CustomerBean implements Serializable {

    @Inject
    Services services;
    
    private Integer number = null;
    private String lastName = null;
    private String firstName = null;

    public CustomerBean() {
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    // permet d'ajouter le client dans la bank et grace au retour du String Create. 
    // Nous allons pouvoir nous diriger vers la page NewCustomerSucces
    public String create() {
        services.saveCustomer(this.number, this.firstName, this.lastName);
        return "Create";
    }
}
