/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.AlumneI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Alumne;

/**
 *
 * @author ALUMNEDAM
 */
public class Alumne_controller implements AlumneI {

    @Override
    public Alumne cercarNif(String nif) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a "
                + "WHERE a.nomUsuari =:usuariRegistrat");
        //q.setParameter("usuariRegistrat", usuari);
        return (Alumne) q.getSingleResult();
    }

    @Override
    public Alumne cercarCognom(String cognom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumne> cercarTots() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegir(Alumne clase) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(clase);
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void modificar(Alumne clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Alumne clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
