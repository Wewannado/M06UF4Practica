package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alumne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idAlumne;
    @Column(unique = true)
    private String nif;
    private String nom;
    private String cognom;
    private String correu;
    private String telefon;
    @OneToOne(mappedBy = "alumne")
    private Matricula matricula;

    public Alumne(String nif, String nom, String cognom, String correu, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.cognom = cognom;
        this.correu = correu;
        this.telefon = telefon;      
    }

    public Alumne() {
    }
    

    public Long getIdAlumne() {
        return idAlumne;
    }

    public void setIdAlumne(Long idAlumne) {
        this.idAlumne = idAlumne;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumne != null ? idAlumne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idAlumne fields are not set
        if (!(object instanceof Alumne)) {
            return false;
        }
        Alumne other = (Alumne) object;
        if ((this.idAlumne == null && other.idAlumne != null) || (this.idAlumne != null && !this.idAlumne.equals(other.idAlumne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Alumne[ id=" + idAlumne + " ]";
    }

}
