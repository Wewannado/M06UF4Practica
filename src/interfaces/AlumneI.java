package interfaces;

import model.Alumne;

public interface AlumneI extends GenericaDAO<Alumne> {

    Alumne cercarNif(String nif);

    Alumne cercarCognom(String cognom);

    Alumne cercarTots();
}
