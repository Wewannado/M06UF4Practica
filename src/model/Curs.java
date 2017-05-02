package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

@Entity
public class Curs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idCurs;

    @OneToMany(mappedBy = "curs")
    private List<UnitatFormativa> unidades;

    @OneToMany(mappedBy = "cursMatricula")
    private List<Matricula> matriculas;

    public enum Nom {

        PRIMER, SEGON
    }
    @ManyToOne
    @JoinColumn(name = "idCicle")
    private Cicle cicleCurs;

    public Curs() {
    }

    public Curs(Long id, ArrayList unidades) {
        this.idCurs = id;
        this.unidades = unidades;

    }

    public Long getId() {
        return idCurs;
    }

    public void setId(Long id) {
        this.idCurs = id;
    }

    public List<UnitatFormativa> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnitatFormativa> unidades) {
        this.unidades = unidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurs != null ? idCurs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCurs fields are not set
        if (!(object instanceof Curs)) {
            return false;
        }
        Curs other = (Curs) object;
        return !((this.idCurs == null && other.idCurs != null) || (this.idCurs != null && !this.idCurs.equals(other.idCurs)));
    }

    @Override
    public String toString() {
        return "TODO";
    }

}
