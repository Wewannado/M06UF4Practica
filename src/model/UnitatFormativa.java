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

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
public class UnitatFormativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idUF;

    private String nom;
    private int hores;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private UnitatFormativa uf;

    @ManyToOne
    @JoinColumn(name = "idModul")
    private Modul modul;

    @ManyToOne
    @JoinColumn(name = "idMatricula")
    private Matricula matricula;

    public UnitatFormativa(String nom, int hores, UnitatFormativa uf, Modul modul, Matricula matricula) {
        this.nom = nom;
        this.hores = hores;
        this.uf = uf;
        this.modul = modul;
        this.matricula = matricula;
    }

    public UnitatFormativa() {
    }

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
