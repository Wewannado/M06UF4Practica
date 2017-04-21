package m06uf4practica;

import controlador.Curs_Controller;
import controlador.Matricula_Controller;
import model.Curs;
import model.Matricula;

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
        
        Matricula_Controller mc = new Matricula_Controller();
        Matricula mm = new Matricula();
        mm.setModalitat(Matricula.Modalitat.UFSOLTES);
        mc.Insertar(mm);
        
    }

}
