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
                + "WHERE a.nif =:nifP");
        q.setParameter("nifP", nif);
        return (Alumne) q.getSingleResult();
    }

    @Override
    public List<Alumne> cercarCognom(String cognom) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a "
                + "WHERE a.cognom =:cognomP");
        q.setParameter("cognomP", cognom);
        return (List<Alumne>) q.getResultList();
    }

    @Override
    public List<Alumne> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a ");
        return (List<Alumne>) q.getResultList();
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
    }

    @Override
    public void eliminar(Alumne clase) {
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
    }
}
