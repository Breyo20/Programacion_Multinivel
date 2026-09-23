# RPG Manager Java

## Cómo ejecutar
```
mvn compile exec:java
```
o desde NetBeans/IntelliJ: clic derecho sobre `PersonajeController.java` → Run File.
Luego abre: http://localhost:7070/personajes.html

## Qué se corrigió
1. **`PersonajeServicio.java` no tenía `package`.** Era la causa principal de que el
   proyecto no compilara/ejecutara: `PersonajeController` la importa como
   `com.mycompany.rpg.manager.servicio.PersonajeServicio`, pero al no declarar paquete
   la clase vivía en el "paquete por defecto" y esa importación fallaba.
2. **`pom.xml` apuntaba a la clase equivocada.** `exec.mainClass` señalaba a
   `RpgManagerJava` (el "Hello World" que genera NetBeans al crear el proyecto), no al
   servidor real. Se corrigió para apuntar a `PersonajeController`.
3. **Se quitó `RpgManagerJava.java`.** Era el stub vacío de NetBeans, no formaba parte
   de la aplicación (el servidor real vive en `PersonajeController`).
4. **Estructura reorganizada a convención Maven estándar:**
   - Código fuente: `src/main/java/com/mycompany/rpg/manager/...`
   - Recursos estáticos servidos por Javalin: `src/main/resources/public/personajes.html`
     (antes estaba suelto en la raíz del proyecto, fuera del classpath, por lo que
     `Location.CLASSPATH` no lo habría encontrado al empaquetar el jar).

## Pendiente a futuro (no lo cambié, solo aviso)
`personajes.html` muestra una tabla fija con datos "quemados" (Messias, Daniel).
Cuando agregas un personaje nuevo con el formulario, se guarda en el repositorio y
puedes verlo en `GET /personajes` (JSON), pero la tabla del HTML no se actualiza sola
porque no hay JavaScript que la llene dinámicamente. Si quieres que la tabla se
actualice sola, dime y te ayudo a agregarlo.
