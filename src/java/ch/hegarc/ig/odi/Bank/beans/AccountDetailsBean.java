package ch.hegarc.ig.odi.Bank.beans;

import ch.hegarc.ig.odi.Bank.business.Account;
import ch.hegarc.ig.odi.Bank.service.Services;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class AccountDetailsBean {

    @Inject
    Services services;
    Account accountEdit;

    public Account getAccountEdit() {
        return accountEdit;
    }

    public void setAccountEdit(Account accountEdit) {
        this.accountEdit = accountEdit;
    }

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of CustomerEditBean
     */
    public AccountDetailsBean() {
    }

    @PostConstruct
    public void init() {
        accountEdit = services.getAccountEdit();
    }
}
