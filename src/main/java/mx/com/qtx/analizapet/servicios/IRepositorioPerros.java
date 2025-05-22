package mx.com.qtx.analizapet.servicios;
import java.util.*;

import mx.com.qtx.analizapet.entidades.Perro;

public interface IRepositorioPerros {
    Perro getById(String id);
    List<Perro> buscarPorVacunacion(boolean vacunado);
    List<Perro> buscarPorRaza(String raza);
    boolean insertar(Perro perro);
    boolean eliminar(String id);
    List<Perro> obtenerTodos();
}

