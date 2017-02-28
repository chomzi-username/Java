
package pl.goralczyk.controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.entity.Pacjent;


public class PacjentBean {
    private Pacjent pacjent = new Pacjent();
    private String username;
    private String haslo;

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        pacjent.setId(null);
        em.persist(pacjent);
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Dodano pacjenta!");
        this.pacjent = new Pacjent();
        return null;
    }

    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }

    public void pacjentListener() {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pacjentID");//.toString()
        int id = Integer.parseInt(ids);
        this.pacjent.setId(id);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.pacjent = em.find(Pacjent.class, pacjent.getId());
        em.close();
        return "/edytujpacjenta.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.pacjent = em.find(Pacjent.class, pacjent.getId());
        em.remove(this.pacjent);
        this.pacjent = new Pacjent();
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Usunięto pacjenta");
        return null;
    }

    public List<Pacjent> getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Pacjent.findAll").getResultList();
        em.close();
        return list;
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(this.pacjent);
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Zmieniono dane pacjenta!");
        this.pacjent = new Pacjent();
        return "/pokazpacjenta.xhtml";
    }
    
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    
}
