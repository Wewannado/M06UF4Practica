package interfaces;

import java.util.List;
import model.Curs;

public interface CursI extends GenericaDAO<Curs> {

    List<Curs> cercarTots();
}
