package controller;

import io.javalin.Javalin;
import model.Personaje;
import model.PersonajeRepositorio;

public class PersonajeController {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {

        // GET
        config.routes.get("/personajes", ctx -> {
            ctx.json(PersonajeRepositorio.obtenerTodos());
        });

        // POST
        config.routes.post("/personajes", ctx -> {

            Personaje personaje = ctx.bodyAsClass(Personaje.class);

            PersonajeRepositorio.guardar(personaje);

            ctx.status(201);
            });

        }).start(7070);
    }
}