package mx.com.qtx.analizapet.test;

import mx.com.qtx.analizapet.entidades.Perro;

public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro(
            "Firulais",
            "Golden Retriever",
            3,
            "Dorado",
            25.5,
            true,
            false
        );
        
        miPerro.ladrar();
        System.out.println(miPerro.obtenerInformacion());
        
        // Modificar un atributo
        miPerro.setEdad(4);
        miPerro.setPeso(26.8);
        System.out.println("\nDatos actualizados:");
        System.out.println(miPerro.obtenerInformacion());
    }
}