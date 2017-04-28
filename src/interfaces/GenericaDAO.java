package interfaces;

public interface GenericaDAO<T> {

    boolean afegir(T clase);

    boolean modificar(T clase);

    boolean eliminar(T clase);
}
