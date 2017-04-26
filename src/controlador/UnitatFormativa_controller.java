/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.UnitatFormativaI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.UnitatFormativa;

/**
 *
 * @author ALUMNEDAM
 */
public class UnitatFormativa_controller implements UnitatFormativaI {

    @Override
    public List<UnitatFormativa> cercarTots() {
        EM_Controller emc = new EM_Controller();
        EntityManager em = emc.getEntityManager();
        Query q = em.createQuery("SELECT u FROM UnitatFormativa u");
        return (List<UnitatFormativa>) q.getResultList();
    }

    @Override
    public void afegir(UnitatFormativa clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(UnitatFormativa clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(UnitatFormativa clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
