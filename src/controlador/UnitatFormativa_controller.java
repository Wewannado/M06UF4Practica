/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.UnitatFormativaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.UnitatFormativa;

/**
 *
 * @author ALUMNEDAM
 */
public class UnitatFormativa_controller implements UnitatFormativaI {

    @Override
    public List<UnitatFormativa> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT u FROM UnitatFormativa u");
        return (List<UnitatFormativa>) q.getResultList();
    }

    @Override
    public boolean afegir(UnitatFormativa clase) {
         EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(clase);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    @Override
    public boolean modificar(UnitatFormativa clase) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.merge(clase);
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    @Override
    public boolean eliminar(UnitatFormativa clase) {
         EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.remove(em.contains(clase) ? clase : em.merge(clase));
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    @Override
    public UnitatFormativa cercarUF(String nom) {
       EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM UnitatFormativa a "
                + "WHERE a.nom =:nomP");
        q.setParameter("nomP", nom);
        return (UnitatFormativa) q.getSingleResult();
    }

}
