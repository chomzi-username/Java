
package pl.goralczyk.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class WizytaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "lekarz", nullable = false)
    private int lekarz;
    @Basic(optional = false)
    @Column(name = "pacjent", nullable = false)
    private int pacjent;
    @Basic(optional = false)
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public WizytaPK() {
    }

    public WizytaPK(int lekarz, int pacjent, Date data) {
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.data = data;
    }

    public int getLekarz() {
        return lekarz;
    }

    public void setLekarz(int lekarz) {
        this.lekarz = lekarz;
    }

    public int getPacjent() {
        return pacjent;
    }

    public void setPacjent(int pacjent) {
        this.pacjent = pacjent;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lekarz;
        hash += (int) pacjent;
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WizytaPK)) {
            return false;
        }
        WizytaPK other = (WizytaPK) object;
        if (this.lekarz != other.lekarz) {
            return false;
        }
        if (this.pacjent != other.pacjent) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.goralczyk.entity.WizytaPK[ lekarz=" + lekarz + ", pacjent=" + pacjent + ", data=" + data + " ]";
    }
    
}
