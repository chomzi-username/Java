
package pl.goralczyk.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "logowanie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logowanie.findAll", query = "SELECT l FROM Logowanie l")
    , @NamedQuery(name = "Logowanie.findById", query = "SELECT l FROM Logowanie l WHERE l.id = :id")
    , @NamedQuery(name = "Logowanie.findByUsername", query = "SELECT l FROM Logowanie l WHERE l.username = :username")
    , @NamedQuery(name = "Logowanie.findByPassword", query = "SELECT l FROM Logowanie l WHERE l.password = :password")})
public class Logowanie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @JoinColumn(name = "pacjent", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pacjent pacjent;

    public Logowanie() {
    }

    public Logowanie(Integer id) {
        this.id = id;
    }

    public Logowanie(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
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
        if (!(object instanceof Logowanie)) {
            return false;
        }
        Logowanie other = (Logowanie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.goralczyk.entity.Logowanie[ id=" + id + " ]";
    }
    
}
