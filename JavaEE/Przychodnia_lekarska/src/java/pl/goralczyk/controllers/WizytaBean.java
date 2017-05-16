package pl.goralczyk.controllers;

import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.entity.*;

public class WizytaBean {

    private Pacjent pacjent = new Pacjent();
    private PacjentBean pacjentBean = new PacjentBean();
    private Wizyta wizyta;
    private Wizyta staraWizyta;
    private int przychodniaId;
    private int pacjentId;

    public WizytaBean() {
        this.inicjujWizyte();
    }

    private void inicjujWizyte() {
        this.wizyta = new Wizyta();
        this.wizyta.setWizytaPK(new WizytaPK());
        this.staraWizyta = null;
    }

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    public int getPrzychodniaId() {
        return przychodniaId;
    }

    public void setPrzychodniaId(int przychodniaId) {
        this.przychodniaId = przychodniaId;
    }

    public int getPacjentId() {
        return pacjentId;
    }

    public void setPacjentId(int pacjentId) {
        this.pacjentId = pacjentId;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(wizyta);
        try {
            em.getTransaction().commit();
        } catch (RollbackException re) {
            return "/addVisitWarning.xhtml";
        } finally {
            em.close();
        }
        this.inicjujWizyte();
        return "/addVisitSuccess.xhtml";

    }

    public List<Wizyta> getListaWizyt() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List<Wizyta> lista;
        lista = em.createQuery("from Wizyta w WHERE w.lekarz1.przychodnia.id=:id").setParameter("id", this.getPrzychodniaId()).getResultList();
        em.close();
        return lista;
    }

    public void wizytaListener() {
        String kluczTekst = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("wizytaPK");
        WizytaPK klucz = Wizyta.convertStringAsWizytaPK(kluczTekst);
        this.wizyta = new Wizyta();
        this.wizyta.setWizytaPK(klucz);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.wizyta = em.find(Wizyta.class, wizyta.getWizytaPK());
        this.staraWizyta = new Wizyta(wizyta.getWizytaPK().getLekarz(), wizyta.getWizytaPK().getPacjent(), wizyta.getWizytaPK().getData());
        em.close();
        return "/editVisit.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.wizyta = em.find(Wizyta.class, wizyta.getWizytaPK());
        em.remove(this.wizyta);
        this.inicjujWizyte();
        em.getTransaction().commit();
        em.close();
        return "/showVisits.xhtml";
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        if (this.wizyta.equals(this.staraWizyta)) {
            em.merge(this.wizyta);
        } else {
            em.remove(em.find(Wizyta.class, this.staraWizyta.getWizytaPK()));
            em.persist(this.wizyta);
        }
        try {
            em.getTransaction().commit();
        } catch (RollbackException re) {
            return "/editVisitWarning.xhtml";
        } finally {
            em.close();
        }
        this.inicjujWizyte();
        return "/editVisitSuccess.xhtml";
    }
}
