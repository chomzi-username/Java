package pl.goralczyk.controllers;

import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pl.goralczyk.config.DBManager;
import pl.goralczyk.config.DataConnect;
import pl.goralczyk.entity.Pacjent;
import pl.goralczyk.entity.Przychodnia;

@SessionScoped
public class PacjentBean {

    private Pacjent pacjent = new Pacjent();
    private String username;
    private String password;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int przychodniaID;
    private long ID;
    private int pacjentId;
    DataConnect dc;
    
    public int getPacjentId() {
        return pacjentId;
    }

    public void setPacjentId(int pacjentId) {
        this.pacjentId = pacjentId;
    }

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

    public int getPrzychodniaID() {
        return przychodniaID;
    }

    public void setPrzychodniaID(int przychodniaID) {
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

    public List<PacjentBean> getUserList() {
        List<PacjentBean> list = new ArrayList<PacjentBean>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DataConnect.getConnection();
            String sql = "select * from pacjent";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PacjentBean usr = new PacjentBean();
                usr.setID(rs.getInt("ID"));
                usr.setImie(rs.getString("imie"));
                usr.setNazwisko(rs.getString("nazwisko"));
                usr.setPesel(rs.getString("pesel"));
                usr.setPrzychodniaID(rs.getInt("przychodnia"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("haslo"));
                list.add(usr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DataConnect.close(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
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
                return true;
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
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

        this.pacjent = em.find(Pacjent.class,
                 pacjent.getId());
        em.close();
        return "/editPatient.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();

        this.pacjent = em.find(Pacjent.class,
                 pacjent.getId());
        em.remove(this.pacjent);
        this.pacjent = new Pacjent();
        em.getTransaction().commit();
        em.close();
        return null;
    }

    public List<Pacjent> getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Pacjent.findAll").getResultList();
        em.close();
        return list;
    }

    public List<Pacjent> getListOfPerson() {
        EntityManager em = DBManager.getManager().createEntityManager();//w.lekarz1.przychodnia.id=:id"
        List<Pacjent> lista = em.createNamedQuery("SELECT p FROM Pacjent p WHERE p.id = :id").getResultList();
        em.close();
        return lista;
    }

    public String edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(this.pacjent);
        em.getTransaction().commit();
        em.close();
        this.pacjent = new Pacjent();
        return "/editPatientSuccess.xhtml";//nie podmienia danych tylko dodaje nowego użytkownika(mozliwe ze dlatgo ze nie wyswietla wszystkich danych)
    }

}
