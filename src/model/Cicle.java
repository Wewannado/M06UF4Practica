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

@Entity
public class Cicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idCicle;
    @Column(unique = true)
    private String nom;
    private String grau;
    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familia familia;
    @OneToMany(mappedBy = "cicleModul")
    private List<Modul> moduls;
    @OneToMany(mappedBy = "cicleCurs")
    private List<Curs> cursos;

    @OneToMany(mappedBy = "cicleMatricula")
    private List<Matricula> matriculas;

    public Cicle(String nom, String grau, Familia familia) {
        this.nom = nom;
        this.grau = grau;
        this.familia = familia;
    }

    public Cicle() {
    }

    public Long getIdCicle() {
        return idCicle;
    }

    public void setIdCicle(Long idCicle) {
        this.idCicle = idCicle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public List<Modul> getModuls() {
        return moduls;
    }

    public void setModuls(List<Modul> moduls) {
        this.moduls = moduls;
    }

    public List<Curs> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curs> cursos) {
        this.cursos = cursos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCicle != null ? idCicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCicle fields are not set
        if (!(object instanceof Cicle)) {
            return false;
        }
        Cicle other = (Cicle) object;
        if ((this.idCicle == null && other.idCicle != null) || (this.idCicle != null && !this.idCicle.equals(other.idCicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cicle[ id=" + idCicle + " ]";
    }

}
