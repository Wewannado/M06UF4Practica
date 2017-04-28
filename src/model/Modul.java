/*
 * Author Roger G. Coscojuela
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idModul;
    @Column(unique = true)
    private String nom;
    @ManyToOne
    @JoinColumn(name = "idCicle")
    private Cicle cicleModul;
    @OneToMany(mappedBy = "modul")
    private List<UnitatFormativa> uF;

    public Long getId() {
        return idModul;
    }

    public void setId(Long id) {
        this.idModul = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModul != null ? idModul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idModul fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.idModul == null && other.idModul != null) || (this.idModul != null && !this.idModul.equals(other.idModul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Modul[ id=" + idModul + " ]";
    }

    public Long getIdModul() {
        return idModul;
    }

    public void setIdModul(Long idModul) {
        this.idModul = idModul;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Cicle getCicleModul() {
        return cicleModul;
    }

    public void setCicleModul(Cicle cicleModul) {
        this.cicleModul = cicleModul;
    }

    public List<UnitatFormativa> getuF() {
        return uF;
    }

    public void setuF(List<UnitatFormativa> uF) {
        this.uF = uF;
    }
    
    

}
