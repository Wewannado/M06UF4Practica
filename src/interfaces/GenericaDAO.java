package interfaces;

public interface GenericaDAO<T> {

    void afegir(T clase);

    void modificar(T clase);

    void eliminar(T clase);
}
