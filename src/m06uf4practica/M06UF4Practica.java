package m06uf4practica;

import controlador.Curs_Controller;
import controlador.Matricula_Controller;
import controlador.Modul_controller;
import controlador.UnitatFormativa_controller;
import java.util.List;
import model.Curs;
import model.Matricula;
import model.Modul;
import model.UnitatFormativa;

/**
 *
 * @author Roger G. Coscojuela
 */
public class M06UF4Practica {

    public static void main(String[] args) {
        // TODO code application logic here
        
        //Curs_Controller cc = new Curs_Controller();
        //Curs c = new Curs();
        //cc.Insertar(c);
        
//        Matricula_Controller mc = new Matricula_Controller();
//        Matricula mm = new Matricula();
//        mm.setModalitat("UFSOLTES");
//        mc.Insertar(mm);
        
        //UnitatFormativa_controller ufc = new UnitatFormativa_controller();
//        UnitatFormativa uf = new UnitatFormativa();
//        uf.setNom("UF4");
//        uf.setHores(300);
//        ufc.afegir(uf);
        
//        Modul_controller mc = new Modul_controller();
//        Modul md = new Modul();
//        md.setNom("M09");
        
        
//        mc.afegir(md);
        
        //UnitatFormativa ufM09= ufc.cercarUF("UF4");
       // System.out.println(ufM09.getHores());
        
        
        Curs_Controller cc = new Curs_Controller();
        
        List <Curs> cursos = cc.cercarTots();
        System.out.println("Hola!");
        System.out.println("Tamany"+cursos.size());
        for (Curs curso : cursos) {
            List <UnitatFormativa> uflista= curso.getUnidades();
            System.out.println("Lista!");
             System.out.println(uflista.size());
            for (UnitatFormativa uflista1 : uflista) {
                System.out.println("Hola!!!!!!2");
                System.out.println("Curso"+curso.getNom()+ uflista1.toString());
            }
        }
    }

}
