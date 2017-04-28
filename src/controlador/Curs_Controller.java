/*
 * Author Roger G. Coscojuela
 */
package controlador;

import interfaces.CursI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Curs;

/**
 *
 * @author Roger G. Coscojuela
 */
public class Curs_Controller implements CursI {

    @Override
    public List<Curs> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Curs c ");
        return (List<Curs>) q.getResultList();
    }

    @Override
    public void afegir(Curs curs) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(curs);
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void modificar(Curs curs) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.merge(curs);
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void eliminar(Curs curs) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.remove(em.contains(curs) ? curs : em.merge(curs));
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }
}
