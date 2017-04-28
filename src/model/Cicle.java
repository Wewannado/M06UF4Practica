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

    public Cicle(Long idCicle, String nom, String grau, List<Modul> moduls, List<Curs> cursos) {
        this.idCicle = idCicle;
        this.nom = nom;
        this.grau = grau;
        this.moduls = moduls;
        this.cursos = cursos;
    }

    public Cicle() {
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
