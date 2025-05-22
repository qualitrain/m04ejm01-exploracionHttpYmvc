<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Perros</title>
    <link rel="stylesheet" href="estiloFormulario.css">
</head>
<body>
    <div class="form-container">
        <h2>Registro de Perro</h2>
        <form action="ctrl" method="post">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" 
                       value="${param.nombre}" required>
                <span class="error">${errorNombre}</span> 
            </div>

            <div class="form-group">
                <label for="raza">Raza:</label>
                <input type="text" id="raza" name="raza" 
                       value="${not empty param.raza ? param.raza : ''}" required>
            </div>

            <div class="form-group">
                <label for="edad">Edad (años):</label>
                <input type="number" id="edad" name="edad" min="0" max="30" 
                       value="${not empty param.edad ? param.edad : 0}" required>
            </div>

            <div class="form-group">
                <label for="color">Color:</label>
                <input type="text" id="color" name="color" 
                       value="${not empty param.color ? param.color : ''}" required>
            </div>

            <div class="form-group">
                <label for="peso">Peso (kg):</label>
                <input type="number" id="peso" name="peso" step="0.1" min="0" max="100" 
                       value="${not empty param.peso ? param.peso : 0.0}" required>
            </div>

            <div class="form-group">
                <label>Estado de vacunación:</label>
                <div class="radio-group">
                    <label>
                        <input type="radio" name="vacunado" value="si" 
                               ${param.vacunado eq 'si' ? 'checked' : ''} required> Sí
                    </label>
                    <label>
                        <input type="radio" name="vacunado" value="no" 
                               ${param.vacunado eq 'no' ? 'checked' : ''}> No
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label>Esterilizado:</label>
                <div class="radio-group">
                    <label>
                        <input type="radio" name="esterilizado" value="si" 
                               ${param.esterilizado eq 'si' ? 'checked' : ''} required> Sí
                    </label>
                    <label>
                        <input type="radio" name="esterilizado" value="no" 
                               ${param.esterilizado eq 'no' ? 'checked' : ''}> No
                    </label>
                </div>
            </div>
			<input type="hidden" value="alta_perro_jsp" name="vista">

            <button type="submit">Registrar Perro</button>
            <button type="button" id="sugerenciasBtn">Sugerencias</button>
        </form>
        
        <a href="Analizar?animal=${not empty animal ? animal : 'Gato'}&color=${not empty color ? color : 'amarillo'}">
            Navegar a otro lado
        </a>
        
        <script src="alta_perro.js"></script>
    </div>
</body>
</html>