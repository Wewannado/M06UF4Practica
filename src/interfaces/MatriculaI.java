package interfaces;

import java.util.List;
import model.Cicle;
import model.Curs;
import model.Familia;
import model.Matricula;
import model.UnitatFormativa;

public interface MatriculaI extends GenericaDAO<Matricula> {

    List<Matricula> cercarPerUf(UnitatFormativa uf);

    List<Matricula> cercarPerCurs(Curs curs);

    List<Matricula> cercarPerCicle(Cicle cicle);

    List<Matricula> cercarPerFamilia(Familia familia);

    Matricula cercarPerNif(String nif);

    List<Matricula> cercarTots();
}
