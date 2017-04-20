/*
 * Author Roger G. Coscojuela
 */

package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import model.Curs;

/**
 *
 * @author Roger G. Coscojuela
 */
public class Curs_Controller {

 
    public boolean Insertar(Curs c) throws RollbackException{
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(c);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    public Curs Buscar(String nom) throws NoResultException{
        //Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("busqueda");
        Query query = em.createNamedQuery("userPerNom", Curs.class);
        query.setParameter("nom", nom);
        Curs c = (Curs) query.getSingleResult();
        System.out.println("close");
        em.close();
        return c;
    }
}