package ch.hegarc.ig.odi.Bank.service;

import ch.hegarc.ig.odi.Bank.business.Account;
import ch.hegarc.ig.odi.Bank.business.Bank;
import ch.hegarc.ig.odi.Bank.business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les données de l'application dans la session de l'utilisateur.
 * Cette classe est gérée par CDI et peut donc être injectée dans les autres classes Java.
 * @author julien.plumez
 */
@SessionScoped
@Stateful
public class Services implements Serializable{
 
    private static final long serialVersionUID = 1L;
    private Bank bank;
    private Customer customerEdit;
    private Account accountEdit;

    public Services() {
        bank = new Bank(1, "Raiffeisen Neuchâtel");

        Customer cust = bank.addCustomer(1, "Jean", "Dupont");

        bank.addAccount("1", "Salaire", 0.001, cust);
        bank.addAccount("2", "Impots", 0.002, cust);

        cust = bank.addCustomer(2, "Marie", "Dupont");
        bank.addAccount("3", "Epargne", 0.002, cust);
        bank.addAccount("4", "Salaire", 0.001, cust);
    }

    /**
     * Dit à la banque de créer un nouveau client.
     *
     * @param number Le numéro unique du client
     * @param fn Le prénom du client
     * @param ln Le nom du client
     */
    public void saveCustomer(Integer number, String fn, String ln) {
        bank.addCustomer(number, fn, ln);
    }

    /**
     * Retourne le client de la banque qui correspond au numéro passé en
     * paramètre.
     *
     * @param number Le numéro du client à rechercher
     * @return Le client, ou null s'il n'est pas trouvé
     */
    public Customer getCustomer(Integer number) {
        return bank.getCustomerByNumber(number);
    }

    /**
     * Retourne une Map contenant tous les clients de la banqe
     *
     * @return Une Map contenant tous les clients de la banqe
     */
    public Map<Integer, Customer> getCustomers() {
        return bank.getCustomers();
    }

    /**
     * Retourne une List contenant tous les clients de la banque. Utile pour
     * l'affichage des clients dans les facelets
     *
     * @return Une List contenant tous les clients de la banque.
     */
    public List<Customer> getCustomersList() {
        return new ArrayList(getCustomers().values());
    }

    /**
     * Retourne le client qui doit être édité par le Managed Bean.
     *
     * @return Le client qui doit être édité par le Managed Bean
     */
    public Customer getCustomerEdit() {
        return getCustomer(customerEdit.getNumber());
    }

    /**
     * Définit le client qui devra être édité par la suite dans l'application.
     * L'avantage de cette solution est qu'elle permet une libre navigation dans
     * les sous-formulaires et n'est pas limité à la requête.
     *
     * @param customerEdit Le client à éditer
     */
    public void setCustomerEdit(Customer customerEdit) {
        this.customerEdit = customerEdit;
    }

    /**
     * Dit à la banque de créer un nouveau compte. Le client est automatiquement
     * définit grâce à l'attribut customerEdit de la classe Services.
     *
     * @param number Le numéro du compte
     * @param name Le libellé du compte
     * @param rate Le taux d'intérêts du compte
     */
    public void saveAccount(String number, String name, Double rate) {
        bank.addAccount(number, name, rate, customerEdit);
    }

    /**
     * Retourne le compte qui doit être édité par le Managed Bean.
     *
     * @return Le compte qui doit être édité par le Managed Bean
     */
    public Account getAccountEdit() {
        return bank.getAccountByNumber(accountEdit.getNumber());
    }

    /**
     * Définit le compte qui devra être édité par la suite dans l'application.
     * L'avantage de cette solution est qu'elle permet une libre navigation dans
     * les sous-formulaires et n'est pas limité à la requête.
     *
     * @param accountEdit Le compte à éditer.
     */
    public void setAccountEdit(Account accountEdit) {
        this.accountEdit = accountEdit;
    }
    
    public Collection<Account> getAccountsByCustomer(Customer customer) {
        return bank.getAccountsByCustomer(customer);
    }
}
