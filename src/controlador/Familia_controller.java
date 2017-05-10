package controlador;

import exceptions.NotFoundException;
import interfaces.FamiliaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Familia;

public class Familia_controller implements FamiliaI {

    /**
     * Método en el cual hacemos una búsqueda total y nos retorna una lista de
     * familias
     *
     * @return
     */
    @Override
    public List<Familia> cercarTots() throws NotFoundException{
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT f FROM Familia f ");
        try{
        return (List<Familia>) q.getResultList();
        }catch (javax.persistence.NoResultException ex) {
            throw new NotFoundException();
        }
    }

    /**
     * Método que le pasamos un nombre por parámetro y hacemos una busqueda por
     * ese nombre especifico
     *
     * @param nom
     * @return
     */
    public Familia cercarFamilia(String nom) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT f FROM Familia f "
                + "WHERE f.nom =:nomP");
        q.setParameter("nomP", nom);
        return (Familia) q.getSingleResult();
    }

    /**
     * Método que buscamos una familia a raiz de su id, devolvemos un objeto
     * Familia
     *
     * @param id
     * @return
     */
    public Familia cercarFamiliaId(Long id) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT f FROM Familia f "
                + "WHERE f.idFamilia =:idP");
        q.setParameter("idP", id);
        return (Familia) q.getSingleResult();
    }

    /**
     * Con este método añadimos una familia a la base de datos
     *
     * @param familia
     * @return
     */
    @Override
    public boolean afegir(Familia familia) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(familia);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    /**
     * Recibimos un objeto familia y le hacemos la sobreescritura comparandolo
     * con el de la base de datos
     *
     * @param familia
     * @return
     */
    @Override
    public boolean modificar(Familia familia) {
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
        return true;
    }

    /**
     * Con este método realizamos un borrado de una familia que esté en la base
     * de datos
     *
     * @param familia
     * @return
     */
    @Override
    public boolean eliminar(Familia familia) {
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
        return true;
    }

}
