package pl.goralczyk.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.config.DataConnect;
import pl.goralczyk.config.SessionUtils;
import pl.goralczyk.entity.Logowanie;
import pl.goralczyk.entity.Pacjent;
import pl.goralczyk.entity.Przychodnia;

@SessionScoped
@ManagedBean(name = "logowanieBean")
public class LogowanieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String password;
    private String uname;
    private PacjentBean pacjentBean;

    private String imie;
    private String nazwisko;
    private String pesel;
    private Przychodnia przychodniaID;
    private long ID;
    private Pacjent pacjent = new Pacjent();

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Przychodnia getPrzychodniaID() {
        return przychodniaID;
    }

    public void setPrzychodniaID(Przychodnia przychodniaID) {
        this.przychodniaID = przychodniaID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
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

    public List<Logowanie> getListOfPerson() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Logowanie.findAll").getResultList();
        em.close();
        return list;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            
                request.login(this.uname, this.password);
           
                return "/patientPage.xhtml";
            
            
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login failed."));
            return "/loginPageWarning.xhtml";
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
        return "/index.xhtml";
    }

    public String validateUsernamePassword() {
        boolean valid = PacjentBean.validate(uname, password);
        if (valid) {
            if (uname.equals("admin") && password.equals("admin")) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", uname);
                session.setAttribute("haslo", password);

                return "/adminPage.xhtml";
            } else {
                return "/patientPage.xhtml";
            }
        } else {
            return "/loginPageWarning.xhtml";
        }

    }
/*
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        return "/index.xhtml";
    }*/

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
