package interfaces;

import java.util.List;
import model.Alumne;

public interface AlumneI extends GenericaDAO<Alumne> {

    Alumne cercarNif(String nif);

    List<Alumne> cercarCognom(String cognom);

    List<Alumne> cercarTots();
}
