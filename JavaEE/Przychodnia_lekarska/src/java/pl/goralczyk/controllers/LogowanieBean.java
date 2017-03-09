package pl.goralczyk.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.*;
import pl.goralczyk.config.SessionUtils;
import pl.goralczyk.entity.Pacjent;

@RequestScoped
@ManagedBean(name = "logowanieBean")
public class LogowanieBean extends HttpServlet {

    private String user;
    private String pass;
    private PacjentBean pacjentBean;
    private Pacjent pacjent;

    //validate login
    public String validateUsernamePassword() {
        boolean valid = pacjentBean.validate(user, pass);
        if (valid) {
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "/patientPage.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "",""));
            return "/loginWarning.xhtml";
        }
    }

    public String wyloguj() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/loginPage.xhtml";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
