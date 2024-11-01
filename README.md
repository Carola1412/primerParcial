Primer parcial, Carolina Martinez, 48876

# INFORMACION SOBRE LA API 
Esta API permite detectar si una persona es mutante o no a travez de su secuencia de ADN. Utiliza como base de datos H2, y esta hosteada en Render: https://mutante-7wrp.onrender.com
## Nivel 2: Endpoints 

Hacemos una solicitud HTTP POST en formato JSON a la URL https://xmenparcial1.onrender.com/api/v1/dna/mutant a través de Postman. En el cuerpo de la solicitud, escribimos:
 {adn : [arreglo de strings NxN]}
Lo que esto hará es verificar si una secuencia de ADN pertenece a un mutante y la almacena en la base de datos.
Si la secuencia de ADN no es mutante, al enviar esa solicitud, el endpoint devolverá una respuesta 403 Forbidden. Si el ADN pertene a un mutante, devolverá una respuesta 200-OK.
Pero si al enviar una solicitud a la API la matriz de ADN no es de tipo n x n o si contiene letras que no son válidas (es decir, que no son 'A', 'T', 'C' o 'G'), la respuesta mostrará el siguiente mensaje de error: {"error":"Error, por favor intente más tarde"}. Esto indica que la secuencia de ADN enviada no cumple con lo necesario.

## Nivel 3: Stats
Para ejecutar el comando /stats primero realizamos una solicitud HTTP GET a la ruta https://mutante-7wrp.onrender.com/api/v1/adn/statsa través de Postman, al realizar esta solicitud podremos ver las estadísticas de forma separada, detallando la cantidad de humanos, cantidad de mutantes y ratio(cantidad de mutantes por cada humano)


