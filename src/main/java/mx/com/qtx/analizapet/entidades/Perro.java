package mx.com.qtx.analizapet.entidades;
public class Perro {
    // Campos o atributos
    private String nombre;
    private String raza;
    private int edad;
    private String color;
    private double peso; // en kilogramos
    private boolean vacunado;
    private boolean esterilizado;

    // Constructor
    public Perro(String nombre, String raza, int edad, String color, double peso, boolean vacunado, boolean esterilizado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.color = color;
        this.peso = peso;
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    // Método para representar la acción de ladrar
    public void ladrar() {
        System.out.println("¡Guau! ¡Guau!");
    }

    // Método para mostrar información básica
    public String obtenerInformacion() {
        return "Nombre: " + nombre +
               "\nRaza: " + raza +
               "\nEdad: " + edad + " años" +
               "\nColor: " + color +
               "\nPeso: " + peso + " kg" +
               "\nVacunado: " + (vacunado ? "Sí" : "No") +
               "\nEsterilizado: " + (esterilizado ? "Sí" : "No");
    }
}