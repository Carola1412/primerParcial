Primer parcial, Carolina Martinez, 48876

# INFORMACION SOBRE LA API 
Esta API permite detectar si una persona es mutante o no a travez de su secuencia de ADN. Utiliza como base de datos H2, y esta hosteada en Render: https://mutante-7wrp.onrender.com
## Nivel 2: Endpoints 
Con la ruta https://mutante-7wrp.onrender.com/api/v1/adn/mutant/, con el comando POST en Postman, permite verificar si una secuencia de ADN pertenece a un mutante y la almacena en la base de datos.
Hacemos una solicitud HTTP POST en formato JSON a la URL https://xmenparcial1.onrender.com/api/v1/dna/mutant a través de Postman. En el cuerpo de la solicitud, escribimos:


1. Para ejecutar /mutant/ y crear agregar un nuevo ADN a la base de datos se debe utilizar la URL de render https://mutante-7wrp.onrender.com/api/v1/adn/mutant/, colocando en el body un JSON con el formato {adn : [arreglo de strings NxN]}, si devuelve  un HTTP OK si el ADN que enviaste corresponde al de un mutante, con un msj adicilonal que te dice si es mutante, pero si  devuelve un HTTP FORBIDDEN es por que no corresponde con los datos de un mutante
2. Luego para ejecutar el comando /stats hay que ir al siguiente URL https://mutante-7wrp.onrender.com/api/v1/adn/stats y podremos ver las estadísticas de forma separada, detallando la cantidad de humanos, cantidad de mutantes y ratio(cantidad de mutantes por cada humano)
