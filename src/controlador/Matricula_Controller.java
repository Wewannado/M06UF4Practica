package controlador;

import interfaces.MatriculaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import model.Cicle;
import model.Curs;
import model.Familia;

import model.Matricula;
import model.UnitatFormativa;

public class Matricula_Controller implements MatriculaI {

    public void Insertar(Matricula m) throws RollbackException {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(m);
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public Matricula cercarPerUf(UnitatFormativa uf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula cercarPerCurs(Curs curs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula cercarPerCicle(Cicle cicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula cercarPerFamilia(Familia familia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula cercarPerNif(String nif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Matricula> cercarTots() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegir(Matricula clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Matricula clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Matricula clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
