# Aprendizaje — Mini Tasks

## Test de normalización del título

Primero se creó el test `createStripsTitleEdges()` para comprobar que, al crear una tarea con el título `"  Repasar Spring Boot  "`, se eliminaran los espacios del principio y del final. El test también comprueba que el atributo `done` sea `false`.

Al ejecutar el test por primera vez, falló porque el servicio guardaba el título original, incluidos los espacios sobrantes.

Para solucionarlo, se modificó `TaskService` para utilizar el método `strip()` sobre el título antes de guardar la tarea.

Después se ejecutaron de nuevo los tests y se obtuvo `BUILD SUCCESS`.

## Conservación de los espacios interiores

También se añadió el test `createPreservesSpacesBetweenWords()`, que comprueba que los espacios entre palabras se conservan.

El test pasó correctamente, confirmando que la normalización elimina únicamente los espacios de los extremos y mantiene los espacios interiores.