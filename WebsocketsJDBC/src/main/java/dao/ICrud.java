package dao;

import java.util.List;

public interface ICrud<T> {

    void registrar(T modelo) throws Exception;

    void editar(T modelo) throws Exception;

    void eliminar(T modelo) throws Exception;

    List<T> listar() throws Exception;

    List<T> listar(T modelo) throws Exception;

    T obtenerModelo(T modelo) throws Exception;

}
