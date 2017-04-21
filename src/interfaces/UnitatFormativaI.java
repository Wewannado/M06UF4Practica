package interfaces;

import java.util.List;
import model.UnitatFormativa;

public interface UnitatFormativaI extends GenericaDAO<UnitatFormativa> {

    List<UnitatFormativa> cercarTots();
}
