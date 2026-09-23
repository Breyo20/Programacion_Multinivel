package com.mycompany.rpg.manager.servicio;

public class PersonajeServicio {

    public boolean validarPersonaje(String nombre, String clase, int nivel) {
        //1. Validar nombre no nulo ni vacio o con puros espacios
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        // 2. Validar clase no nula y que sea Guerrero, Mago o Arquero (sin importar mayúsculas)
        if (!clase.equalsIgnoreCase("Guerrero") &&
            !clase.equalsIgnoreCase("Mago") &&
            !clase.equalsIgnoreCase("Arquero")) {
            return false;
        }
        //3. Valida si el nivel esta en ese rango de 1 a 100
        if (nivel < 1 || nivel > 100) {
            return false;
        }
        //4. Si pasa todos los filtros, debe devolver un boolean y el personaje es valido
        return true;
    }

}
