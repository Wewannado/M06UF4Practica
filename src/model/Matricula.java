package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idMatricula;

    @OneToOne
    @JoinColumn(name = "idAlumne", unique = true)
    private Alumne alumne;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "matricula")
    private List<UnitatFormativa> ufs;

    private String modalitat;

    private int descompte;

    @ManyToOne
    @JoinColumn(name = "idCicle")
    private Cicle cicleMatricula;

    @ManyToOne
    @JoinColumn(name = "idCurs")
    private Curs cursMatricula;

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familia familiaMatricula;

    public Matricula() {
    }

    public Matricula(Alumne alumne, Date fecha, String modalitat, int descompte, Cicle cicleMatricula, Curs cursMatricula, Familia familiaMatricula) {
        this.alumne = alumne;
        this.fecha = fecha;
        this.modalitat = modalitat;
        this.descompte = descompte;
        this.cicleMatricula = cicleMatricula;
        this.cursMatricula = cursMatricula;
        this.familiaMatricula = familiaMatricula;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cicle getCicleMatricula() {
        return cicleMatricula;
    }

    public void setCicleMatricula(Cicle cicleMatricula) {
        this.cicleMatricula = cicleMatricula;
    }

    public Curs getCursMatricula() {
        return cursMatricula;
    }

    public void setCursMatricula(Curs cursMatricula) {
        this.cursMatricula = cursMatricula;
    }

    public Familia getFamiliaMatricula() {
        return familiaMatricula;
    }

    public void setFamiliaMatricula(Familia familiaMatricula) {
        this.familiaMatricula = familiaMatricula;
    }

}
