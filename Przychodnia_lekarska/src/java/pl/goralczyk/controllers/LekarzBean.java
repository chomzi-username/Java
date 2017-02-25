
package pl.goralczyk.controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.entity.Lekarz;


public class LekarzBean {
    private Lekarz lekarz = new Lekarz();

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        lekarz.setId(null);
        em.persist(lekarz);
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Dodano lekarza!");
        this.lekarz = new Lekarz();
        return null;
    }

    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }

    public void lekarzListener() {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("lekarzID").toString();
        int id = Integer.parseInt(ids);
        this.lekarz.setId(id);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.lekarz = em.find(Lekarz.class, lekarz.getId());
        em.close();
        return "/edytujlekarza.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.lekarz = em.find(Lekarz.class, lekarz.getId());
        em.remove(this.lekarz);
        this.lekarz = new Lekarz();
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Usunięto lekarza");
        return null;
    }

    public List<Lekarz> getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Lekarz.findAll").getResultList();
        em.close();
        return list;
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(this.lekarz);
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Zmieniono dane lekarza!");
        this.lekarz = new Lekarz();
        return "/pokazlekarzy.xhtml";
    }
}
