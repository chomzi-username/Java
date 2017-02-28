/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.goralczyk.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "przychodnia")
@NamedQueries({
    @NamedQuery(name = "Przychodnia.findAll", query = "SELECT p FROM Przychodnia p")
    , @NamedQuery(name = "Przychodnia.findById", query = "SELECT p FROM Przychodnia p WHERE p.id = :id")
    , @NamedQuery(name = "Przychodnia.findByNazwa", query = "SELECT p FROM Przychodnia p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Przychodnia.findByAdres", query = "SELECT p FROM Przychodnia p WHERE p.adres = :adres")
    , @NamedQuery(name = "Przychodnia.findByKontakt", query = "SELECT p FROM Przychodnia p WHERE p.kontakt = :kontakt")})
public class Przychodnia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazwa", nullable = false, length = 255)
    private String nazwa;
    @Basic(optional = false)
    @Lob
    @Column(name = "opis", nullable = false, length = 65535)
    private String opis;
    @Column(name = "adres", length = 150)
    private String adres;
    @Column(name = "kontakt", length = 30)
    private String kontakt;
    @OneToMany(mappedBy = "przychodnia", fetch = FetchType.EAGER)
    private Set<Pacjent> pacjentSet;
    @OneToMany(mappedBy = "przychodnia", fetch = FetchType.EAGER)
    private Set<Lekarz> lekarzSet;

    public Przychodnia() {
    }

    public Przychodnia(Integer id) {
        this.id = id;
    }

    public Przychodnia(Integer id, String nazwa, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Set<Pacjent> getPacjentSet() {
        return pacjentSet;
    }

    public void setPacjentSet(Set<Pacjent> pacjentSet) {
        this.pacjentSet = pacjentSet;
    }

    public Set<Lekarz> getLekarzSet() {
        return lekarzSet;
    }

    public void setLekarzSet(Set<Lekarz> lekarzSet) {
        this.lekarzSet = lekarzSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Przychodnia)) {
            return false;
        }
        Przychodnia other = (Przychodnia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.goralczyk.entity.Przychodnia[ id=" + id + " ]";
    }
    
}
