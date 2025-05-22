package mx.com.qtx.analizapet.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import mx.com.qtx.analizapet.entidades.Perro;
import mx.com.qtx.analizapet.servicios.IRepositorioPerros;

public class RepositorioPerros implements IRepositorioPerros {
    private final Map<String, Perro> perros = new ConcurrentHashMap<>();
    
    public RepositorioPerros() {
		super();
		cargaPerros(this);
	}
    
	public static void cargaPerros(IRepositorioPerros repositorio) {
        List<Perro> perrosPrueba = Arrays.asList(
            new Perro("Max", "Labrador", 3, "Dorado", 25.5, true, false),
            new Perro("Luna", "Pastor Alemán", 2, "Negro", 20.0, true, true),
            new Perro("Rocky", "Bulldog", 5, "Blanco", 15.8, false, false),
            new Perro("Bella", "Golden Retriever", 4, "Crema", 27.3, true, false),
            new Perro("Toby", "Beagle", 7, "Tricolor", 12.1, true, true),
            new Perro("Daisy", "Poodle", 1, "Blanco", 5.5, false, false),
            new Perro("Thor", "Husky", 3, "Gris y Blanco", 22.0, true, false),
            new Perro("Lola", "Chihuahua", 2, "Marrón", 3.2, false, true),
            new Perro("Bruno", "Boxer", 4, "Atigrado", 30.5, true, true),
            new Perro("Molly", "Dálmata", 6, "Blanco con negro", 18.7, true, false)
        );

        perrosPrueba.forEach(perro -> {
            if (!repositorio.insertar(perro)) {
                System.err.println("Error insertando perro de prueba: " + perro.getNombre());
            }
        });
    }
    @Override
    public Perro getById(String id) {
        return perros.get(id);
    }

    @Override
    public List<Perro> buscarPorVacunacion(boolean vacunado) {
        return perros.values().stream()
            .filter(p -> p.isVacunado() == vacunado)
            .collect(Collectors.toList());
    }

    @Override
    public List<Perro> buscarPorRaza(String raza) {
        return perros.values().stream()
            .filter(p -> p.getRaza().equalsIgnoreCase(raza))
            .collect(Collectors.toList());
    }

    @Override
    public boolean insertar(Perro perro) {
        if (perro == null || perro.getNombre() == null || perro.getNombre().trim().isEmpty()) {
            return false;
        }
        
        String nombre = perro.getNombre().trim();
        if (perros.containsKey(nombre)) {
            return false; // Ya existe
        }
        
        perros.put(nombre, perro);
        return true;
    }

    @Override
    public boolean eliminar(String id) {
        return perros.remove(id) != null;
    }

    // Método adicional para obtener todos los perros (útil para pruebas)
    public List<Perro> obtenerTodos() {
        return new ArrayList<>(perros.values());
    }
}