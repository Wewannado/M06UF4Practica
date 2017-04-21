package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idMatricula;

    @OneToOne
    private Alumne alumne;

    private Date fecha;

    @OneToMany(mappedBy = "uf")
    private List<UnitatFormativa> ufs;

    
    private String modalitat;

    private int descompte;

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Date getDate() {
        return fecha;
    }

    public void setDate(Date date) {
        this.fecha = date;
    }

    public List<UnitatFormativa> getUfs() {
        return ufs;
    }

    public void setUfs(List<UnitatFormativa> ufs) {
        this.ufs = ufs;
    }

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public int getDescompte() {
        return descompte;
    }

    public void setDescompte(int descompte) {
        this.descompte = descompte;
    }

}
