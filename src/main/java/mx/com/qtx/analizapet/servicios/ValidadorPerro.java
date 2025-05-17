package mx.com.qtx.analizapet.servicios;
import java.util.*;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.qtx.analizapet.entidades.Perro;

public class ValidadorPerro {
    private final Map<String, String> datosBrutos;
    private final Perro perro;
    private final Map<String, List<String>> errores = new HashMap<>();
    private final int contadorErrores;

    public ValidadorPerro(HttpServletRequest request) {
        this.datosBrutos = extraerParametros(request);
        this.perro = new Perro("", "", 0, "", 0.0, false, false);
        this.realizarBinding();
        this.validarPerro();
        this.contadorErrores = calcularTotalErrores();
    }

    private Map<String, String> extraerParametros(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        request.getParameterMap().forEach((key, valores) -> {
            if (valores != null && valores.length > 0) {
                params.put(key, valores[0]);
            }
        });
        return params;
    }

    private void realizarBinding() {
//      procesarCampo("nombre", ()->this.procesarNombre());
    	procesarCampo("nombre", this::procesarNombre);
        procesarCampo("raza", this::procesarRaza);
        procesarCampo("edad", this::procesarEdad);
        procesarCampo("color", this::procesarColor);
        procesarCampo("peso", this::procesarPeso);
        procesarCampo("vacunado", this::procesarVacunado);
        procesarCampo("esterilizado", this::procesarEsterilizado);
    }

    private void procesarCampo(String campo, Runnable procesador) {
        try {
            procesador.run();
        } catch (Exception e) {
            agregarError(campo, "Error en formato: " + e.getMessage());
        }
    }

    private void procesarNombre() {
        String valor = datosBrutos.getOrDefault("nombre", "").trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("Campo requerido");
        perro.setNombre(valor);
    }

    private void procesarRaza() {
        String valor = datosBrutos.getOrDefault("raza", "").trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("Campo requerido");
        perro.setRaza(valor);
    }

    private void procesarEdad() {
        String valor = datosBrutos.getOrDefault("edad", "").trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("Campo requerido");
        perro.setEdad(Integer.parseInt(valor));
    }

    private void procesarColor() {
        String valor = datosBrutos.getOrDefault("color", "").trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("Campo requerido");
        perro.setColor(valor);
    }

    private void procesarPeso() {
        String valor = datosBrutos.getOrDefault("peso", "").trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("Campo requerido");
        perro.setPeso(Double.parseDouble(valor));
    }

    private void procesarVacunado() {
        String valor = datosBrutos.getOrDefault("vacunado", "").trim().toLowerCase();
        if (valor.equals("si")) perro.setVacunado(true);
        else if (valor.equals("no")) perro.setVacunado(false);
        else throw new IllegalArgumentException("Valor inválido (solo 'si'/'no')");
    }

    private void procesarEsterilizado() {
        String valor = datosBrutos.getOrDefault("esterilizado", "").trim().toLowerCase();
        if (valor.equals("si")) perro.setEsterilizado(true);
        else if (valor.equals("no")) perro.setEsterilizado(false);
        else throw new IllegalArgumentException("Valor inválido (solo 'si'/'no')");
    }

    private void validarPerro() {
        validarNombre();
        validarRaza();
        validarEdad();
        validarColor();
        validarPeso();
        validarBoolean("vacunado", perro.isVacunado());
        validarBoolean("esterilizado", perro.isEsterilizado());
    }

    private void validarNombre() {
        String valor = perro.getNombre();
        if (valor.length() < 3) agregarError("nombre", "Mínimo 3 caracteres");
        if (!valor.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{3,}$")) {
            agregarError("nombre", "Solo caracteres alfabéticos válidos");
        }
    }

    private void validarRaza() {
        String valor = perro.getRaza();
        if (valor.length() < 3) agregarError("raza", "Mínimo 3 caracteres");
        if (!valor.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{3,}$")) {
            agregarError("raza", "Solo caracteres alfabéticos válidos");
        }
    }

    private void validarEdad() {
        int valor = perro.getEdad();
        if (valor <= 0) agregarError("edad", "Debe ser positivo");
        if (valor >= 20) agregarError("edad", "Máximo 19 años");
    }

    private void validarColor() {
        String valor = perro.getColor();
        if (valor.length() < 4) agregarError("color", "Mínimo 4 caracteres");
        if (!valor.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{4,}$")) {
            agregarError("color", "Solo caracteres alfabéticos válidos");
        }
    }

    private void validarPeso() {
        double valor = perro.getPeso();
        if (valor <= 0.1) agregarError("peso", "Mínimo 0.1 kg");
    }

    private void validarBoolean(String campo, boolean valor) {
        try {
            if (!datosBrutos.containsKey(campo)) {
                agregarError(campo, "Campo requerido");
            }
        } catch (Exception e) {
            agregarError(campo, "Valor booleano inválido");
        }
    }

    private void agregarError(String campo, String mensaje) {
        errores.computeIfAbsent(campo, k -> new ArrayList<>()).add(mensaje);
    }

    private int calcularTotalErrores() {
        return errores.values().stream().mapToInt(List::size).sum();
    }

    // Métodos públicos
    public Map<String, List<String>> getErrores() {
        return new HashMap<>(errores);
    }

    public boolean esValido() {
        return contadorErrores == 0;
    }

    public Perro getPerroValidado() {
        return esValido() ? perro : null;
    }
    

	public Map<String, String> getDatosBrutos() {
		return datosBrutos;
	}

    
}