package interfaces;

import java.util.List;
import model.Cicle;
import model.Curs;
import model.Familia;
import model.Matricula;
import model.UnitatFormativa;

public interface MatriculaI extends GenericaDAO<Matricula> {

    Matricula cercarPerUf(UnitatFormativa uf);

    Matricula cercarPerCurs(Curs curs);

    Matricula cercarPerCicle(Cicle cicle);

    Matricula cercarPerFamilia(Familia familia);

    Matricula cercarPerNif(String nif);

    List<Matricula> cercarTots();
}
