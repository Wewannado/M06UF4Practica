package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCicle;
    private String nom;
    private String grau;
    @OneToMany(mappedBy = "cicleModul")
    private List<Modul> moduls;
    @OneToMany(mappedBy = "cicleCurs")
    private List<Curs> cursos;

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
