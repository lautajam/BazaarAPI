# BazaarAPI

**Descripción**: La API de Bazar es una plataforma que permite la gestión de clientes, ventas y productos de una tienda. 
Además de las operaciones CRUD básicas, ofrece funcionalidades adicionales para mejorar la eficiencia y análisis del negocio.

## Requisitos

Asegúrate de tener lo siguiente instalado antes de ejecutar la API:

- Java SDK 17
- Spring Boot
- MySQL 8.0+ (para la base de datos)
- Xampp o Wampp (para el servidor de base de datos)

Y las depencesias de Maven:
- Spring Boot DevTools DEVELOPER TOOLS
- Lombok DEVELOPER TOOLS 
- MySQL Driver SQL
- Spring Data JPA SQL
- H2 Database SQL
- Spring Web WEB

Recomiendo utilizar el IDE IntelliJ IDEA para ejecutar la API y para generar el proyecto de Spring Spring Initializr (https://start.spring.io/).

## Instalación

1. Abre la terminal y blona el repositorio en una carpeta de tu equipo:
    mkdir bazaarapi (en tu escritorio)
    cd bazaarapi
    git clone https://github.com/lautajam/BazaarAPI

2. Abre xaamp o wampp y ejecuta el servidor de MySQL

3. Crea una base de datos en MySQL con el nombre "bazaar_db" (o nombrala como quieras y modifica el archivo application.properties)

4. En la terminal, accede al directorio de tu proyecto:
   cd bazaarapi (en tu escritorio)

5. Compila y ejecuta el proyecto:
   mvn spring-boot:run

## Uso
Al momento de inicializarla la documentación de la API se encuentra en el siguiente enlace: localhost:8080/swagger-ui.html (el puerto puede variar)
En la carpeta Postman_Collection estàn todas las colecciones de la api para importar en Postman, està todo preparado para que se puedan
hacer pruebas.