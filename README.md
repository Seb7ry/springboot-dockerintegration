TALLER 1- GRUPOS 3 PERSONAS 
FACULTAD DE INGENIERÍA 
DEVOPS 
DOCENTE: JUAN MANUEL CHAGÜENDO BENAVIDES 
UNIVERSIDAD DE IBAGUÉ 
*Cualquier intento de copia o plagio será penalizado con la anulación del taller de 
todos los involucrados y con nota 0* 
Contexto: 
Un estudio de cinecolombia independiente está desarrollando una plataforma para 
gestionar su catálogo de películas. Sin embargo, el equipo de desarrollo ha enfrentado 
problemas debido a las inconsistencias entre los entornos de trabajo de los 
desarrolladores, pruebas y producción. Esto ha generado conflictos en el código y 
retrasos en la entrega del proyecto. 
Como parte del equipo DevOps, tu responsabilidad es crear un entorno de desarrollo 
estandarizado y replicable para una API REST que maneje la información del catálogo 
de películas. Se utilizará Docker para garantizar que la API funcione correctamente en 
todos los entornos (desarrollo, pruebas y producción), eliminando los errores 
causados por configuraciones locales no uniformes. 
1. Hacer un sprint corto de desarrollo de una funcionalidad haciendo uso de un sistema 
de control de versiones: API rest (contenga información de películas: nombre, 
categoría, año, director, duración, calificación). La API debe permitir realizar 
operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre las películas y 
proporcionar endpoints que devuelvan información en formato JSON. Toda la 
configuración de la API y su entorno debe estar contenedorizada utilizando Docker y 
gestionada con docker-compose para facilitar la ejecución de la API y su base de 
datos en cualquier máquina de manera homogénea. La API debe tener los siguientes 
endpoints básicos: 
GET /peliculas: Listar todas las películas. 
GET /peliculas/{id}: Obtener los detalles de una película por su ID. 
POST /peliculas: Agregar una nueva película. 
PUT /peliculas/{id}: Actualizar los detalles de una película. 
DELETE /peliculas/{id}: Eliminar una película. 
La información de las películas debe ser almacenada en una base de datos. La base 
de datos debe estar dentro de un contenedor de Docker, gestionado mediante 
docker-compose. 
Asegurar que todos los miembros del equipo puedan ejecutar la API REST y 
conectarse a la base de datos con solo usar el comando docker-compose up. 
Probar que los endpoints funcionan correctamente realizando operaciones CRUD 
sobre la base de datos. 
El sprint deberá contener desarrollo, despliegue y monitoreo. De esta primera parte 
del taller deberán entregar (3 puntos): 
a. Código desarrollado 
b. Herramientas y lenguaje utilizado 
c. Documentación en idioma inglés en relación con el despliegue (requisitos 
mínimos del sistema, versiones, lenguaje, paso a paso o manual, comandos, 
etc). Recuerde que este documento deberá ser lo suficientemente claro y útil 
para que cualquier persona nueva dentro del equipo pueda realizar el 
despliegue. 
d. Documentación en idioma inglés en relación con el monitoreo y pruebas (test 
unitarios, proceso de monitoreo y generación de alertas). Recuerde que este 
documento deberá ser lo suficientemente claro y útil para que cualquier 
persona nueva dentro del equipo pueda realizar el monitoreo. 
2. Homogenizar los ambientes involucrados en el sprint, utilizando Docker. De esta 
segunda parte del taller deberán entregar (1 puntos): 
a. Dockerfile 
b. Docker image 
c. Crear dos instancias de una misma imagen Docker, es decir, 2 docker container 
d. Publicar el proyecto en dockerhub 
e. Todos los estudiantes deberán hacer Docker pull y posteriormente Docker run 
del proyecto en cuestión. 
f. 
Documento que contenga todos los ítems anteriores (a…e) en donde se 
evidencie lo solicitado. 
3. Haga y exponga los dos puntos anteriores (se evaluará la claridad de la exposición y 
la sustentación grupal e individual) (1 puntos) 
Notas importantes: 
1. La entrega de este taller en grupos de 3 personas. Los estudiantes conforman 
sus propios grupos. 
2. En cada punto de este taller está indicado los puntos posibles que se pueden 
obtener 
3. La fecha para entregar el taller es el martes 17 de septiembre de 2024 a las 
1pm por medio de moodle. Solo un(1) Estudiante del grupo entrega el trabajo. 
4. Las sustentaciones se realizarán durante la clase el martes 17 de septiembre 
2024. 
5. Todos los estudiantes deberán exponer en clase. 
6. La exposición tendrá una duración máxima de 10-15 minutos. 
7. ¡Ojo con la ortografía! Bajaré nota si hay faltas de ortografía. 
10 DE SEPTIEMBRE DE 2024
