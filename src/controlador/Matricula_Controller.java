package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import model.Matricula;

public class Matricula_Controller {

    public boolean Insertar(Matricula m) throws RollbackException {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(m);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }
}
