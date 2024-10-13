Primer parcial, Carolina Martinez, 48876

1. Para ejecutar /mutant/ y crear agregar un nuevo ADN a la base de datos se debe utilizar la URL de render https://mutante-7wrp.onrender.com/api/v1/adn/mutant/, colocando en el body un JSON con el formato {adn : [arreglo de strings NxN]}, si devuelve  un HTTP OK si el ADN que enviaste corresponde al de un mutante, con un msj adicilonal que te dice si es mutante, pero si  devuelve un HTTP FORBIDDEN es por que no corresponde con los datos de un mutante
2. Luego para ejecutar el comando /stats hay que ir al siguiente URL https://mutante-7wrp.onrender.com/api/v1/adn/stats y podremos ver las estadísticas de forma separada, detallando la cantidad de humanos, cantidad de mutantes y ratio(cantidad de mutantes por cada humano)
