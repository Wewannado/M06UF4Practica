/*
 * Author Roger G. Coscojuela
 */

package exceptions;

/**
 *
 * @author Roger G. Coscojuela
 */
public class NotFoundException extends Exception{

    String missatge=null;

    public NotFoundException(String missatge) {
        this.missatge = missatge;
    }
    
    public NotFoundException() {
    }
    
    @Override
    public String toString() {
        return "NotFoundException: "+missatge;
    }

    
    
    
    
}
