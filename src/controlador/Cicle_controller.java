package controlador;

import interfaces.CicleI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Cicle;
import exceptions.NotFoundException;

public class Cicle_controller implements CicleI {

    /**
     * Método que nos hace una consulta total en la tabla Cicle y retornamos una
     * lista de objetos Cicle
     *
     * @return
     */
    @Override
    public List<Cicle> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Cicle c ");
        return (List<Cicle>) q.getResultList();
    }

    /**
     * Método que le pasamos un nombre por parámetro que realiza una consulta en
     * la base de datos y retornamos un objeto Cicle
     *
     * @param nom
     * @return
     * @throws exceptions.NotFoundException
     */
    public Cicle cercarCicle(String nom) throws NotFoundException {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Cicle c "
                + "WHERE c.nom =:nomP");
        q.setParameter("nomP", nom);
        try {
            return (Cicle) q.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            throw new NotFoundException("No s'ha trobat el cicle: " + nom);
        }
    }

    public Cicle cercarCicleId(Long id) throws exceptions.NotFoundException {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT c FROM Cicle c "
                + "WHERE c.idCicle =:idP");
        q.setParameter("idP", id);
        try {
            return (Cicle) q.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            throw new NotFoundException("No s'ha trobat el cicle amb id : " + id);
        }
    }

    /**
     * Método que le pasamos un objeto cicle por parámetro y lo añadimos en la
     * base de datos
     *
     * @param cicle
     * @return
     */
    @Override
    public boolean afegir(Cicle cicle) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(cicle);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    /**
     * Método que le pasamos un cicle por parámetro y modificamos el Ciclo
     * actual por el pasado por parámetro
     *
     * @param cicle
     * @return
     */
    @Override
    public boolean modificar(Cicle cicle) {
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
        return true;
    }

    /**
     * Método que le pasamos un cicle por parámetro y lo eliminamos de la base
     * de datos
     *
     * @param cicle
     * @return
     */
    @Override
    public boolean eliminar(Cicle cicle) {
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
        return true;
    }

}
