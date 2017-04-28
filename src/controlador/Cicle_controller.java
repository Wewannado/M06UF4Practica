package controlador;

import interfaces.CicleI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Cicle;

public class Cicle_controller implements CicleI {

    @Override
    public List<Cicle> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Cicle c ");
        return (List<Cicle>) q.getResultList();
    }

    @Override
    public void afegir(Cicle cicle) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(cicle);
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void modificar(Cicle cicle) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.merge(cicle);
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }

    @Override
    public void eliminar(Cicle cicle) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();
        System.out.println("remove");
        em.remove(em.contains(cicle) ? cicle : em.merge(cicle));
        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();
        System.out.println("close");
        em.close();
    }

}
