package ch.hegarc.ig.odi.Bank.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(value="langBean")
@SessionScoped
public class LangBean implements Serializable{
    public LangBean() {}
    
    public void toFrench(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
    }
    
    public void toEnglish(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }
    
    public void langChange(ValueChangeEvent val) {
        String newLang = (String)val.getNewValue();
        if (newLang.equals("1"))
            toFrench();
        else if (newLang.equals("2"))
            toEnglish();
    }
}
