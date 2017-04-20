/*
 * Author Roger G. Coscojuela
 */
package m06uf4practica;

import controlador.Curs_Controller;
import model.Curs;

/**
 *
 * @author Roger G. Coscojuela
 */
public class M06UF4Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Curs_Controller cc = new Curs_Controller();
        Curs c = new Curs();
        cc.Insertar(c);
        
    }
    
}
