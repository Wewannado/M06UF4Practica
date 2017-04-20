/*
 * Author Roger G. Coscojuela
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
@NamedQuery(name = "CursId", query = "SELECT c FROM Client c WHERE c.id=:id")
@Table(name = "M6UF4_CURS")
public class Curs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ArrayList<Object> uF;

    public enum Nom {

        PRIMER, SEGON
    }

    public Curs() {
    }

    public Curs(Long id, ArrayList uF) {
        this.id = id;
        this.uF = uF;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Object> getuF() {
        return uF;
    }

    public void setuF(ArrayList<Object> uF) {
        this.uF = uF;
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
        if (!(object instanceof Curs)) {
            return false;
        }
        Curs other = (Curs) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "TODO";
    }

}
