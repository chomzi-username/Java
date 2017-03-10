
package pl.goralczyk.controllers;

import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.config.DataConnect;
import pl.goralczyk.entity.Pacjent;

@SessionScoped
public class PacjentBean {
    private Pacjent pacjent = new Pacjent();
    private String username;
    private String password;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String przychodniaID;
    private String ID;
    DataConnect dc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getPrzychodniaID() {
        return przychodniaID;
    }

    public void setPrzychodniaID(String przychodniaID) {
        this.przychodniaID = przychodniaID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = (PreparedStatement) con.prepareStatement("Select username, haslo from pacjent where username = ? and haslo = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            //System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close((com.mysql.jdbc.Connection) con);
        }
        return false;
    }
    public static boolean login(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select username, haslo from pacjent where username = ? and haslo = ?");
            ps.setString(1, user);
            ps.setString(2, password);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                //System.out.println(rs.getString("user"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            //System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
    }
    
    public String dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        pacjent.setId(null);
        em.persist(pacjent);
        em.getTransaction().commit();
        em.close();
        //this.dodajInformacje("Dodano pacjenta!");
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
    
}

    
    
