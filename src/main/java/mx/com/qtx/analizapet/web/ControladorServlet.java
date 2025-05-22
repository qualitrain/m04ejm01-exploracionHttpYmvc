package mx.com.qtx.analizapet.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.analizapet.servicios.GestorPerros;
import mx.com.qtx.analizapet.servicios.ValidadorPerro;

/**
 * Servlet implementation class ProcesaPerroServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorPerros gestorPerros = new GestorPerros();

    /**
     * Default constructor. 
     */
    public ControladorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = request.getParameter("vista");
		switch(vista) {
			case "arranque"->{
				navegarA(request, response, "/alta_perro.html");
			}
			case "alta_perro"->{
				UtilWeb.analizarContenidoHTTPpeticion(request);
				ValidadorPerro validadorPerro = this.gestorPerros.validarPerro(request);
				if(validadorPerro.esValido()) {
					// Navegar a vista de exito
				}
				else {
					Map<String, List<String>> errores = validadorPerro.getErrores();
					Map<String, String> valsCapturados = validadorPerro.getDatosBrutos();
					for(String campoI : errores.keySet()) {
						System.out.println(campoI + "[" + valsCapturados.get(campoI) + "]"
								+ " tiene los errores siguientes:");
						for(String errorK:errores.get(campoI)) {
							System.out.println("\t" + errorK);
						}
					}
				}
			}
		}
	}

	private void navegarA(HttpServletRequest request, HttpServletResponse response, String nvaVista)
			throws ServletException, IOException {
		this.getServletContext()
		    .getRequestDispatcher(nvaVista)
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
