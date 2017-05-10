package interfaces;

import exceptions.NotFoundException;
import java.util.List;
import model.Curs;

public interface CursI extends GenericaDAO<Curs> {

    List<Curs> cercarTots()throws NotFoundException;
}
