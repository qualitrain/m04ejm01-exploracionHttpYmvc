<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Perros</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #4CAF50;
            color: white;
        }
        
        tr:hover {
            background-color: #f5f5f5;
        }
        
        .empty-list {
            color: #666;
            padding: 20px;
            text-align: center;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Listado de Perros Registrados</h2>
    
    <c:choose>
        <c:when test="${empty perros}">
            <div class="empty-list">No hay perros registrados</div>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Edad</th>
                        <th>Color</th>
                        <th>Peso (kg)</th>
                        <th>Vacunado</th>
                        <th>Esterilizado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${perros}" var="perro">
                        <tr>
                            <td>${perro.nombre}</td>
                            <td>${perro.raza}</td>
                            <td>${perro.edad}</td>
                            <td>${perro.color}</td>
                            <td>${perro.peso}</td>
                            <td>${perro.vacunado ? 'Sí' : 'No'}</td>
                            <td>${perro.esterilizado ? 'Sí' : 'No'}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <form action="ctrl" method="post">
	    <input type="hidden" name="vista" value="listaPerros">
	    <button type="submit">Regresar</button>
    </form>
</body>
</html>