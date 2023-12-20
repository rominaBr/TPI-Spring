RABAJO PRÁCTICO SPRING
Realizar el siguiente trabajo práctico final, aplicando lo visto de JAVA y SPRING en clases.

Fecha de entrega : 22/12/2023

ESCENARIO

La Plataforma de Streaming de Música es una aplicación que ofrece a los usuarios la posibilidad de disfrutar de una amplia biblioteca musical, reproducir canciones, crear listas de reproducción personalizadas y conectarse con sus artistas favoritos. Esta plataforma no solo se enfoca en la reproducción de música, sino que también fomenta la interacción social y la exploración musical.

Entidades:

Usuario : El cual se conoce como datos, el id, nombre, nombre de usuario y listas de reproducción.
Canción : Se conoce como datos Id, nombre, ranking, géneros, duración, artista, álbum.
Género : Se tiene como datos el id, nombre y las canciones.
Artista : El cual se conoce como datos, el id, nombre.
Lista de reproducción : El cual se compone del usuario al que pertenece la lista, las canciones, repetir lista al finalizar, si esta se puede reproducir aleatoriamente y si esta es públicas.

Se debe además agregar una entidad de auditoría.

Funcionalidades requeridas:

Exploración y Búsqueda: Permitir búsqueda avanzada que permite encontrar canciones por género, artista, álbum o título. Los usuarios pueden descubrir nueva música basada en sus preferencias.
Búsqueda aleatoria de canciones por título, género, artista o álbum.
La búsqueda canciones por artista ordenada por ranking
La búsqueda específica de un artista dado un id
La búsqueda de listas de reproducciones públicas por nombre.




Perfil de Usuario: Cada usuario tiene un perfil donde este tiene listas de reproducción compuestas por canciones.
Se debe permitir la creación de usuarios. Cada usuario tiene un id, nombre de usuario único y puede o no tener lista de reproducción
Se debe permitir obtener la información del usuario, junto con las listas de reproducción que tenga. De cada playlist solo me interesa su nombre, id y cantidad de canciones.

Listas de Reproducción: Los usuarios pueden crear listas de reproducción personalizadas con sus canciones preferidas e indicarles opciones como : Repetir toda la lista o reproducir aleatoriamente.

Se debe permitir listar las listas de reproducción de un usuario indicando su id. El listado debe estar ordenado por fecha de creación.
Se debe permitir listar las canciones de la lista de reproducción. Indicando con el id la lista de reproducción.
Se debe permitir crear una lista de reproducción pasando un listado de canciones y nombre.
Se debe permitir actualizar la playlist a pública, si se puede repetir la lista al finalizar y si esta se puede reproducir aleatoriamente. 
Se debe permitir eliminar y/o agregar canciones a la lista, indicando id de la lista de reproducción y id de la canción.

Para los puntos 3, 4 y 5 se debe permitir estas acciones si y sólo si el usuario que actualiza/elimina la lista de reproducción es creador de la misma.


Consideraciones adicionales:

Utilizar una base de datos ya sea mysql, oracle o H2.
Utilizar el framework Spring Boot para la construcción de la aplicación, aprovechando su capacidad de gestión de dependencias y configuración automática.
Podrías optar por crear un diagrama de clases antes de pasar al código.
NO ES NECESARIO, realizar validación de datos, es opcional, sin embargo tendrás más puntaje si lo haces.
NO ES NECESARIO, pero podrían optar por hacer una carga masiva de datos.
