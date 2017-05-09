package controlador;

import interfaces.MatriculaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Cicle;
import model.Curs;
import model.Familia;

import model.Matricula;
import model.UnitatFormativa;

public class Matricula_Controller implements MatriculaI {

    public Matricula cercarMatriculaId(Long id) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m "
                + "WHERE m.idMatricula =:idP");
        q.setParameter("idP", id);
        return (Matricula) q.getSingleResult();
    }

    @Override
    public List<Matricula> cercarPerUf(UnitatFormativa uf) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m.alumne FROM Matricula m"
                + " WHERE m.idMatricula IN (SELECT uf.idMatricula "
                + "FROM UnitatFormativa uf WHERE uf:=ufP)");
        q.setParameter("ufP", uf);
        return (List<Matricula>) q.getResultList();
    }

    @Override
    public List<Matricula> cercarPerCurs(Curs curs) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m "
                + "WHERE m.cursMatricula =:cursP");
        q.setParameter("cursP", curs);
        return (List<Matricula>) q.getResultList();
    }

    @Override
    public List<Matricula> cercarPerCicle(Cicle cicle) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m "
                + "WHERE m.cicleMatricula =:cicleP");
        q.setParameter("cicleP", cicle);
        return (List<Matricula>) q.getResultList();
    }

    @Override
    public List<Matricula> cercarPerFamilia(Familia familia) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m "
                + "WHERE m.familiaMatricula =:FamiliaP");
        q.setParameter("FamiliaP", familia);
        return (List<Matricula>) q.getResultList();
    }

    @Override
    public Matricula cercarPerNif(String nif) {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m "
                + "WHERE m.alumne.nif =:nifP");
        q.setParameter("nifP", nif);
        return (Matricula) q.getSingleResult();
    }

    @Override
    public List<Matricula> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Matricula m ");
        return (List<Matricula>) q.getResultList();
    }

    @Override
    public boolean afegir(Matricula clase) {
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

    @Override
    public boolean modificar(Matricula clase) {
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

    @Override
    public boolean eliminar(Matricula clase) {
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
