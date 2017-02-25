package pl.goralczyk.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "logowanieBean")
public class LogowanieBean {

    private String login;
    private String password;

    @ManagedProperty(value = "#{pacjentBean}")
    private PacjentBean pacjentBean;

    public String submit() {
        if (this.login.equals("SYSTEM")) {
            return "/blad";
        }
        getPacjentBean().setLogin(this.login);
        return "/index.xhtml";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public PacjentBean getPacjentBean(){
        return pacjentBean;
    }
    
    public void setPacjentBean(PacjentBean pacjentBean){
        this.pacjentBean = pacjentBean;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
}
