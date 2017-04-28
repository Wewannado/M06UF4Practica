/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.FamiliaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Familia;

/**
 *
 * @author ALUMNEDAM
 */
public class Familia_controller implements FamiliaI {

    @Override
    public List<Familia> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT f FROM Familia f ");
        return (List<Familia>) q.getResultList();
    }

    @Override
    public void afegir(Familia familia) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(familia);
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void modificar(Familia familia) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.merge(familia);
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void eliminar(Familia familia) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.remove(em.contains(familia) ? familia : em.merge(familia));
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }

}
