
# PARCIAL BACK END - Detección de Mutantes
Alumno: Moyano Gonzalo    
Legajo: 47600
Comision: 3K9

Este proyecto es una aplicación Spring Boot que permite detectar si una secuencia de ADN pertenece a un mutante o a un humano. La aplicación también proporciona estadísticas sobre las secuencias de ADN analizadas.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Instalación](#instalación)
- [Funcionamiento](#Funcionamiento)
- [Api EndPoints](#ApiEndpoints)
- [Pruebas JMeter](#pruebasJMeter)
- [Despliegue](#despliegue)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Descripción

El objetivo de este proyecto es determinar si una secuencia de ADN dada pertenece a un mutante o a un humano. 
Una secuencia de ADN se considera mutante si contiene al menos una secuencia repetitiva de cuatro letras iguales (por ejemplo, "AAAA", "TTTT", "CCCC", "GGGG") en cualquier dirección (horizontal, vertical, diagonal).

## Características

- **Detección de Mutantes**: Analiza una secuencia de ADN y determina si es mutante.
- **Estadísticas**: Proporciona estadísticas sobre la cantidad de secuencias de ADN mutantes y humanas, así como el ratio entre ellos.
- **Persistencia de Datos**: Almacena las secuencias de ADN analizadas en una base de datos para futuras consultas.

## Funcionamiento
1. Entrada: El algoritmo recibe una matriz de cadenas de ADN, donde cada cadena representa una fila de la matriz.
2. Definición de Secuencia Mutante: Una secuencia mutante es una secuencia de cuatro letras iguales (por ejemplo, "AAAA", "TTTT", "CCCC", "GGGG") en cualquier dirección (horizontal, vertical, diagonal).
3. Recorrido de la Matriz:
      Horizontal: El algoritmo verifica cada fila de la matriz para encontrar secuencias de cuatro letras iguales.
      Vertical: El algoritmo verifica cada columna de la matriz para encontrar secuencias de cuatro letras iguales.
      Diagonal Descendente: El algoritmo verifica las diagonales que van desde la parte superior izquierda a la parte inferior derecha para encontrar secuencias de cuatro letras iguales.
      Diagonal Ascendente: El algoritmo verifica las diagonales que van desde la parte superior derecha a la parte inferior izquierda para encontrar secuencias de cuatro letras iguales.

 4. Función de Verificación:
-  La función checkSequence se utiliza para verificar si una secuencia de cuatro letras iguales existe en una dirección específica (horizontal, vertical, diagonal).
-  Esta función toma como parámetros la matriz de ADN, las coordenadas iniciales (x, y), y los incrementos (dx, dy) que determinan la dirección de la secuencia.

5. Uso de IntStream:
-  El algoritmo utiliza IntStream para recorrer eficientemente las filas y columnas de la matriz y verificar las secuencias en las direcciones especificadas.

6. Retorno del Resultado:
-  Si se encuentra al menos una secuencia mutante en cualquier dirección, el algoritmo devuelve true, indicando que la secuencia de ADN es mutante.
-  Si no se encuentra ninguna secuencia mutante, el algoritmo devuelve false.

## Api EndPoints
1. POST
-  https://examenparcial-backend-moyanogonzalo-2.onrender.com/mutant  Verifica si una secuencia de ADN es mutante.
-  Request Body:
    {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
    }
-  Response:
    -  200 OK si es mutante.
    -  403 Forbidden si no es mutante.
2. GET
-  https://examenparcial-backend-moyanogonzalo-2.onrender.com/stats  Obtiene estadísticas sobre las secuencias de ADN analizadas.
-  Reponse
    {
    "count_mutant_dna": 4,
    "count_human_dna": 6,
    "ratio": 0.6666666666666666
    }

## Despliegue

-  https://examenparcial-backend-moyanogonzalo-2.onrender.com
  
### Requisitos Previos

- Java 17
- Gradle
- Docker (opcional, para el despliegue)

### Pasos de Instalación

1. **Clonar el Repositorio**:
   ```sh
   git clone https://github.com/GonzaUtn/ExamenParcial--BackEnd--MoyanoGonzalo.git
   cd ExamenParcial--BackEnd--MoyanoGonzalo

## Pruebas JMeter

# 100 peticiones
![JMeter-100peticiones](https://github.com/user-attachments/assets/bda0f6f9-5388-4986-9333-cda2e8a62c34)

# 1000 peticiones
![JMeter-1000peticiones](https://github.com/user-attachments/assets/1b913034-5b8e-482a-b3fb-d5a772381b46)


   
