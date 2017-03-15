
package pl.goralczyk.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "pacjent", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pesel"})})
@NamedQueries({
    @NamedQuery(name = "Pacjent.findAll", query = "SELECT p FROM Pacjent p")
    , @NamedQuery(name = "Pacjent.findById", query = "SELECT p FROM Pacjent p WHERE p.id = :id")
    , @NamedQuery(name = "Pacjent.findByImie", query = "SELECT p FROM Pacjent p WHERE p.imie = :imie")
    , @NamedQuery(name = "Pacjent.findByNazwisko", query = "SELECT p FROM Pacjent p WHERE p.nazwisko = :nazwisko")
    , @NamedQuery(name = "Pacjent.findByPesel", query = "SELECT p FROM Pacjent p WHERE p.pesel = :pesel")
    , @NamedQuery(name = "Pacjent.findByUsername", query = "SELECT p FROM Pacjent p WHERE p.username = :username")
    , @NamedQuery(name = "Pacjent.findByHaslo", query = "SELECT p FROM Pacjent p WHERE p.haslo = :haslo")})
public class Pacjent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "imie", nullable = false, length = 50)
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko", nullable = false, length = 50)
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "pesel", nullable = false, length = 11)
    private String pesel;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @Column(name = "haslo", nullable = false, length = 30)
    private String haslo;
    @JoinColumn(name = "przychodnia", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Przychodnia przychodnia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacjent1", fetch = FetchType.EAGER)
    private Set<Wizyta> wizytaSet;

    public Pacjent() {
    }

    public Pacjent(Integer id) {
        this.id = id;
    }

    public Pacjent(Integer id, String imie, String nazwisko, String pesel, String username, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.username = username;
        this.haslo = haslo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
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

    public Przychodnia getPrzychodnia() {
        return przychodnia;
    }

    public void setPrzychodnia(Przychodnia przychodnia) {
        this.przychodnia = przychodnia;
    }

    public Set<Wizyta> getWizytaSet() {
        return wizytaSet;
    }

    public void setWizytaSet(Set<Wizyta> wizytaSet) {
        this.wizytaSet = wizytaSet;
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
        if (!(object instanceof Pacjent)) {
            return false;
        }
        Pacjent other = (Pacjent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.goralczyk.entity.Pacjent[ id=" + id + " ]";
    }
    
}
