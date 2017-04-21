package interfaces;

import java.util.List;
import model.Cicle;

public interface CicleI extends GenericaDAO<Cicle> {

    List<Cicle> cercarTots();
}
