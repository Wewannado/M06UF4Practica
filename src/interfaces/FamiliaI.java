package interfaces;

import java.util.List;
import model.Familia;

public interface FamiliaI extends GenericaDAO<Familia> {

    List<Familia> cercarTots();
}
