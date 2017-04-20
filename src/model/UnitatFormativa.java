/*
 * Author Roger G. Coscojuela
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
@NamedQuery(name = "UFperNom", query = "SELECT uf FROM UnitatFormativa uf WHERE uf.nom=:nom")
@Table(name = "M6UF4_UF")
public class UnitatFormativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUF;

    private String nom;
    private int hores;
    @JoinColumn(name = "idCurs")
    private UnitatFormativa uf;
    @JoinColumn(name = "idModul")
    private Modul modul;
    @JoinColumn(name = "idMatricula")
    private Matricula matricula;

    public Long getId() {
        return idUF;
    }

    public void setId(Long id) {
        this.idUF = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUF != null ? idUF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idUF fields are not set
        if (!(object instanceof UnitatFormativa)) {
            return false;
        }
        UnitatFormativa other = (UnitatFormativa) object;
        if ((this.idUF == null && other.idUF != null) || (this.idUF != null && !this.idUF.equals(other.idUF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UnitatFormativa[ id=" + idUF + " ]";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

}
