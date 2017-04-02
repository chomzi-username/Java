
package pl.goralczyk.controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.entity.Pacjent;
import pl.goralczyk.entity.Wizyta;
import pl.goralczyk.entity.WizytaPK;


public class WizytaBean {
    private Pacjent pacjent = new Pacjent();
    private Wizyta wizyta;
    private Wizyta staraWizyta;
    private int przychodniaID;

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

    public int getPrzychodniaID() {
        return przychodniaID;
    }

    public void setPrzychodniaID(int przychodniaID) {
        this.przychodniaID = przychodniaID;
    }

    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        pacjent = (Pacjent) em.createQuery("SELECT w FROM Wizyta w WHERE w.wizytaPK.pacjent = :pacjent").setParameter("id", pacjent.getId()).getSingleResult(); 
        em.getTransaction().begin();
        em.persist(wizyta);
        try {
            em.getTransaction().commit();
        } catch (RollbackException re) {
            this.dodajInformacje("Nie udało się dodać wizyty - upewnij się, że taka wizyta nie istnieje!");
            return null;
        } finally {
            em.close();
        }
        this.dodajInformacje("Dodano wizyte!");
        this.inicjujWizyte();
        return null;

    }

    private void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }

    public List<Wizyta> getListaWizyt() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List<Wizyta> lista = em.createQuery("from Wizyta w WHERE w.lekarz1.przychodnia.id=:id").setParameter("id", this.getPrzychodniaID()).getResultList();
        em.close();
        return lista;
    }

    public void wizytaListener() {
        String kluczTekst = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("wizytaPK").toString();
        WizytaPK klucz = Wizyta.convertStringAsWizytaPK(kluczTekst);
        this.wizyta = new Wizyta();
        this.wizyta.setWizytaPK(klucz);
    }

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.wizyta = em.find(Wizyta.class, wizyta.getWizytaPK());
        this.staraWizyta = new Wizyta(wizyta.getWizytaPK().getLekarz(), wizyta.getWizytaPK().getPacjent(), wizyta.getWizytaPK().getData());
        this.staraWizyta.setPokoj(this.wizyta.getPokoj());
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
        this.dodajInformacje("Usunięto wizyte!");
        return null;
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        if(this.wizyta.equals(this.staraWizyta))
            em.merge(this.wizyta);
        else{
            em.remove(em.find(Wizyta.class, this.staraWizyta.getWizytaPK()));
            em.persist(this.wizyta);
        }
        try{
            em.getTransaction().commit();
        }catch(RollbackException re){
            this.dodajInformacje("Nie udało się zmienić danych wizyty - upewnij się, że taka wizyta nie istnieje!");
            return null;
        }finally{
            em.close();
        }
        this.dodajInformacje("Zmieniono dane wizyty!");
        this.inicjujWizyte();
        return "/showVisits.xhtml";
    }
}
