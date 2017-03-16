
package pl.goralczyk.controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.entity.Przychodnia;


public class PrzychodniaBean {

    private Przychodnia przychodnia = new Przychodnia();

    public PrzychodniaBean() {

    }

    public Przychodnia getPrzychodnia() {
        return przychodnia;
    }

    public void setPrzychodnia(Przychodnia przychodnia) {
        this.przychodnia = przychodnia;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        przychodnia.setId(null);
        em.persist(przychodnia);
        em.getTransaction().commit();
        em.close();
        this.przychodnia = new Przychodnia();
        return null;
    }

    public List<Przychodnia> getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Przychodnia.findAll").getResultList();
        em.close();
        return list;
    }

    public void przychodniaListener() {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("przychodniaID").toString();
        int id = Integer.parseInt(ids);
        this.przychodnia.setId(id);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.przychodnia = em.find(Przychodnia.class, przychodnia.getId());
        em.close();
        return "/editClinic.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.przychodnia = em.find(Przychodnia.class, przychodnia.getId());
        em.remove(this.przychodnia);
        this.przychodnia = new Przychodnia();
        em.getTransaction().commit();
        em.close();
        return null;
    }

    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(przychodnia);
        em.getTransaction().commit();
        em.close();
        this.przychodnia = new Przychodnia();
        return "/showClinics.xhtml";
    }

    public String pokazWizyty() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.przychodnia = em.find(Przychodnia.class, przychodnia.getId());
        em.close();
        return "/showVisits.xhtml";
    }
    
    public String dodajWizyte() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.przychodnia = em.find(Przychodnia.class, przychodnia.getId());
        em.close();
        return "/addVisit.xhtml";
    }
}
