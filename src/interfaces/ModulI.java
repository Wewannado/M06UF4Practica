package interfaces;

import java.util.List;
import model.Modul;

public interface ModulI extends GenericaDAO<Modul> {

    List<Modul> cercarTots();
}
