package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EM_Controller {

    public EM_Controller() {
    }

    public EntityManager getEntityManager() {
        //Crear el gestor de persistencia EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
