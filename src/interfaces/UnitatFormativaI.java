package interfaces;

import java.util.List;
import model.UnitatFormativa;

public interface UnitatFormativaI extends GenericaDAO<UnitatFormativa> {

    List<UnitatFormativa> cercarTots();
    
    UnitatFormativa cercarUF(String nom);
}
