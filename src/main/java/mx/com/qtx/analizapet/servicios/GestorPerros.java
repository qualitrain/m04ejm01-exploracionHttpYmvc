package mx.com.qtx.analizapet.servicios;

import jakarta.servlet.http.HttpServletRequest;

public class GestorPerros {
	
	public ValidadorPerro validarPerro(HttpServletRequest req){
		ValidadorPerro validadorPerro = new ValidadorPerro(req);
		return validadorPerro;
	}

}
