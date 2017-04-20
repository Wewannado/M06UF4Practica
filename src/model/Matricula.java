package model;

import utilitats.Modalitat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Matricula implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "alumne")
    @OneToOne
    private Alumne alumne;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "ufs")
    @OneToMany(mappedBy = "matricula")
    private ArrayList <UnitatFormativa> ufs;
    
    @Column(name = "modalitat")
    private Modalitat modalitat;
    
    @Column(name = "descompte")
    private int descompte;
}
