## Para ejecutar el proyecto localmente
ejecutar desde una consola 
    mvn spring-boot:run

También es posible abrirlo desde el IDE y ejecutar la clase ChallengeApplication

#### Base de datos H2 
El challenge levanta una base de datos H2 para acceder ingresar a 

    http://localhost:8080/h2-console

El usuario y passoword estan el archivo application.properties y son los que trae H2 por defecto

#### Agregar nuevas personas
Para agregar nuevas personas a la BD se puede usar el file createPersona.json que esta en la carpeta resources/request
El mismo se puede ejecutar desde postman o insomnia

La fecha debe estar en formato YYYY-MM-DD

#### Ejemplo de curl para relacionar personas:

    curl --request POST \jakarta.*;
    --url http://localhost:8080/persona/2/relacion/4 \
    --header 'Content-Type: application/json'

Existe además en la carpeta request un archivo Insomnia_collection.json que tiene otras operaciones
como delete, update, crearRelacion, getRelacion

