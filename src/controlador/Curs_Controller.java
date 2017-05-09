package controlador;

import interfaces.CursI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Curs;

public class Curs_Controller implements CursI {

    /**
     * Método que hacemos una búsqueda total en la tabla de curso y obtenemos
     * una lista de cursos
     *
     * @return
     */
    @Override
    public List<Curs> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Curs c ");
        return (List<Curs>) q.getResultList();
    }

    /**
     * Método que le pasamos un id por parámetro y nos hace la búsqueda de un
     * curso que x id
     *
     * @param id
     * @return
     */
    public Curs cercarPerId(Long id) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Curs c WHERE c.idCurs=:idP");
        q.setParameter("idP", id);
        return (Curs) q.getSingleResult();
    }



    /**
     * Método que se le pasa un curso por parámetro y lo añadimos a la base de
     * datos
     *
     * @param curs
     * @return
     */
    @Override
    public boolean afegir(Curs curs) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(curs);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    /**
     * Método que le pasamos un curso por parámetro y modificamos el curso
     * actual por el pasado por parámetro
     *
     * @param curs
     * @return
     */
    @Override
    public boolean modificar(Curs curs) {
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
        return true;
    }

    /**
     * Método que le pasamos un curso por parámetro y lo eliminamos de la base
     * de datos
     *
     * @param curs
     * @return
     */
    @Override
    public boolean eliminar(Curs curs) {
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
        return true;
    }
}
