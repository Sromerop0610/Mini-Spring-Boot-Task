
# Aprendizaje — Mini Spring Boot Task

## 1. Listado y creación de tareas en V1

Se implementó el controlador `TaskControllerV1`, con la ruta `/v1/tasks`.

- `GET /v1/tasks` devuelve el listado de tareas.
- `POST /v1/tasks` crea una tarea a partir de `CreateTaskDTO`.
- Las tareas nuevas tienen el atributo `done` a `false`.

Se realizaron pruebas con MockMvc para comprobar el listado y la creación.

## 2. Consulta de tareas por ID

Se implementó `GET /v1/tasks/{id}`.

La prueba comprueba que se devuelve la tarea cuando existe y que se responde con `404 Not Found` cuando no se encuentra.

Para ello se utiliza el repositorio en memoria `InMemoryTaskRepository`.

## 3. Normalización del título mediante TDD

Se creó el test `createStripsTitleEdges()` para comprobar que, al crear una tarea con el título `"  Repasar Spring Boot  "`, se eliminan los espacios del principio y del final.

Inicialmente, el servicio guardaba el título sin normalizar, por lo que la prueba fallaba.

Se modificó `TaskService` para utilizar `strip()` antes de guardar la tarea. Después, los tests pasaron correctamente.

También se creó `createPreservesSpacesBetweenWords()` para comprobar que se mantienen los espacios interiores del título.

## 4. Creación de tareas en V2

Se implementó `TaskControllerV2`, con la ruta `POST /v2/tasks`.

La respuesta utiliza el estado `201 Created` e incluye la cabecera `Location`, que indica la ruta de la tarea creada.

La prueba `createsTaskWith201AndLocation()` comprueba el estado HTTP, la cabecera `Location`, el identificador, el título y el valor inicial de `done`.

## 5. Verificación final

Se ejecutó el comando:

`.\mvnw.cmd clean test`

El resultado fue `BUILD SUCCESS`, por lo que todas las pruebas automatizadas finalizaron correctamente.
