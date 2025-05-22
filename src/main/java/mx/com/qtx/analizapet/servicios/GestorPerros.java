package mx.com.qtx.analizapet.servicios;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.qtx.analizapet.entidades.Perro;
import mx.com.qtx.analizapet.persistencia.RepositorioPerros;

public class GestorPerros {
	
	private IRepositorioPerros repoPerros = new RepositorioPerros();
	
	public ValidadorPerro validarPerro(HttpServletRequest req){
		ValidadorPerro validadorPerro = new ValidadorPerro(req);
		return validadorPerro;
	}
	
	public int insertarPerro(Perro perro) {
		if(this.repoPerros.insertar(perro))
			return 1;
		else
			return 0;
	}
	
	public List<Perro> obtenerPerrosTodos(){
		return this.repoPerros.obtenerTodos();
	}

}
