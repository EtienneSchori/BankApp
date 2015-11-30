package ch.hegarc.ig.odi.Bank.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

// Cette classe va être utile pour le changement de langue au niveau de l'internationalisation

@ManagedBean(value="langBean")
@SessionScoped
public class LangBean implements Serializable{
    public LangBean() {}
    
    
    // Passe de l'anglais au français
    public void toFrench(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
    }
    
    // Passe du français à l'anglais
    public void toEnglish(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }
    
    // Cette Méthode permet de changer la langue du l'application en fonction de la valeur fourni par la liste déroulante à l'acceuil
    public void langChange(ValueChangeEvent val) {
        String newLang = (String)val.getNewValue();
        if (newLang.equals("1"))
            toFrench();
        else if (newLang.equals("2"))
            toEnglish();
    }
}
