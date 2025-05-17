        document.getElementById('sugerenciasBtn').addEventListener('click', function() {
            // Datos de ejemplo para la sugerencia (pueden personalizarse)
            const sugerencia = {
                nombre: 'Ejemplo: Max',
                raza: 'Ejemplo: Labrador',
                edad: 2,
                color: 'Ejemplo: Negro',
                peso: 15.5,
                vacunado: true,
                esterilizado: false
            };

            // Configurar la petición PUT
            const xhr = new XMLHttpRequest();
            xhr.open('PUT', 'sugerencias', true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.status >= 200 && xhr.status < 300) {
                        console.log('Sugerencia enviada con éxito:', xhr.responseText);
                        alert('¡Gracias por tu sugerencia!');
                    } else {
                        console.error('Error al enviar sugerencia:', xhr.statusText);
                        alert('Error al enviar la sugerencia. Intenta nuevamente.');
                    }
                }
            };

            xhr.send(JSON.stringify(sugerencia));
        });
