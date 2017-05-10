package controlador;

import interfaces.AlumneI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import exceptions.NotFoundException;
import model.Alumne;

public class Alumne_controller implements AlumneI {

    /**
     * Método que le pasamos un nif por parámetro y realizamos una consulta para
     * obtener un objeto alumno con los datos de la base de datos.
     *
     * @param nif
     * @return
     * @throws exceptions.NotFoundException
     */
    @Override
    public Alumne cercarNif(String nif) throws NotFoundException{
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a "
                + "WHERE a.nif =:nifP");
        q.setParameter("nifP", nif);
        try{
        return (Alumne) q.getSingleResult();
        }
        catch (javax.persistence.NoResultException ex){
            throw  new NotFoundException("No s'ha trobat el nif: "+nif);
        }
    }

    /**
     * Método que le pasamos un apellido, nos realiza una búsqueda en la base de
     * datos y retornamos una lista de objetos Alumno
     *
     * @param cognom
     * @return
     */
    @Override
    public List<Alumne> cercarCognom(String cognom) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a "
                + "WHERE a.cognom =:cognomP");
        q.setParameter("cognomP", cognom);
        return (List<Alumne>) q.getResultList();
    }

    /**
     * Método que hace una consulta total en la tabla alumno para poder obtener
     * todos los alumnos de la base de datos.
     *
     * @return lista de tipo Alumno
     */
    @Override
    public List<Alumne> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT a FROM Alumne a ");
        return (List<Alumne>) q.getResultList();
    }

    /**
     * Método que le pasamos un objeto Alumno por parámetro y lo añadimos en la
     * base de datos
     *
     * @param clase
     * @return
     */
    @Override
    public boolean afegir(Alumne clase) {
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

    /**
     * Método que le pasamos un objeto Alumno por parámetro y lo modificamos
     * para poder ejecutar los cambios el Alumno seleccionado.
     *
     * @param clase
     * @return
     */
    @Override
    public boolean modificar(Alumne clase) {
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

    /**
     * Método que le pasamos un objeto alumno por parámetro para a su vez
     * eliminarlo de la base de datos.
     *
     * @param clase
     * @return
     */
    @Override
    public boolean eliminar(Alumne clase) {
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
}
