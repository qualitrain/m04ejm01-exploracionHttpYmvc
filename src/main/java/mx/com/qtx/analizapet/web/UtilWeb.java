package mx.com.qtx.analizapet.web;

import java.util.Enumeration;

import jakarta.servlet.http.HttpServletRequest;

public class UtilWeb {
	public static void analizarContenidoHTTPpeticion(HttpServletRequest request) {
		System.out.println("\nAnalizando Petición ===================\n");
		String verboHttp = request.getMethod();
		System.out.println(verboHttp + " " + request.getRequestURI());
		
		Enumeration<String> itHeaders = request.getHeaderNames();
		System.out.println("\nHeaders Http:");
		while(itHeaders.hasMoreElements()) {
			String headerI = itHeaders.nextElement();
			String valorHeaderI = request.getHeader(headerI);
			System.out.println(headerI + ":" + valorHeaderI);
		}
		
		System.out.println("Query String:" + request.getQueryString());
		
		Enumeration<String> itParametros = request.getParameterNames();
		System.out.println("\nParametros:");
		while(itParametros.hasMoreElements()) {
			String paramI = itParametros.nextElement();
			String valorParamI = request.getParameter(paramI);
			System.out.println(paramI + ":" + valorParamI);
		}
	}

}
