package pl.goralczyk.controllers;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;
import pl.goralczyk.config.SessionUtils;

@SessionScoped
@ManagedBean(name = "logowanieBean")
public class LogowanieBean implements Serializable{//extends HttpServlet

    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;
    private PacjentBean pacjentBean;
    
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        boolean result = PacjentBean.login(uname, password);
        if (result) {
            // get Http Session and store username
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", uname);
 
            return "/patientPage.xhtml";
        } else {
            return "/loginPageWarning.xhtml";
        }
    }
 
    public String logout() {
      HttpSession session = SessionUtils.getSession();
      session.invalidate();
      return "/loginPage.xhtml";
   }
    //validate login
    
    public String validateUsernamePassword() {
        boolean valid = PacjentBean.validate(uname, password);
        if (valid) {
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", uname);
            return "/patientPage.xhtml";
        } else {
            return "/loginWarning.xhtml";
        }
    }

    public String wyloguj() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml";
    }

    
    public PacjentBean getPacjentBean() {
        return pacjentBean;
    }

    public void setPacjentBean(PacjentBean pacjentBean) {
        this.pacjentBean = pacjentBean;
    }

    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }

}
