package interfaces;

import java.util.List;
import model.Alumne;
import exceptions.NotFoundException;

public interface AlumneI extends GenericaDAO<Alumne> {

    Alumne cercarNif(String nif) throws NotFoundException;

    List<Alumne> cercarCognom(String cognom);

    List<Alumne> cercarTots();
}
