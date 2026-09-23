package com.mycompany.rpg.manager;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import com.mycompany.rpg.manager.model.Personaje;
import com.mycompany.rpg.manager.model.PersonajeRepositorio;
import com.mycompany.rpg.manager.servicio.PersonajeServicio;

public class PersonajeController {

    public static void main(String[] args) {

        PersonajeServicio servicio = new PersonajeServicio();

        Javalin app = Javalin.create(config -> {
            // Habilitamos la carpeta /public dentro de src/main/resources
            config.staticFiles.add("/public", Location.CLASSPATH);

            // Ruta GET para obtener los personajes
            config.routes.get("/personajes", ctx -> {
                ctx.json(PersonajeRepositorio.obtenerTodos());
            });

            // Ruta POST para recibir datos del formulario HTML
            config.routes.post("/personajes", ctx -> {
                String nombre = ctx.formParam("nombre");
                String clase = ctx.formParam("clase");
                int nivel = Integer.parseInt(ctx.formParam("nivel"));

                if (servicio.validarPersonaje(nombre, clase, nivel)) {
                    Personaje personaje = new Personaje(nombre, clase, nivel, 100);
                    PersonajeRepositorio.guardar(personaje);
                    ctx.redirect("/personajes.html");
                } else {
                    ctx.status(400).result("Datos de personaje inválidos");
                }
            });

        }).start(7070);

        System.out.println("Servidor iniciado en http://localhost:7070");
    }
}
