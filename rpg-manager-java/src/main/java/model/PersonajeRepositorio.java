/*
 * @author Breider
 */

package model;
import java.util.List;
import java.util.ArrayList;

public class PersonajeRepositorio {

    // Lista estática
    private static List<Personaje> personajes = new ArrayList<>();

    // Metodos
    public static List<Personaje> obtenerTodos() {
        return personajes;
    }
    public static void guardar(Personaje p) {
        personajes.add(p);
    }
    
    //Datos
    static {
        personajes.add(new Personaje("Maximo", "Guerrero", 1, 100));
        personajes.add(new Personaje("Merlin", "Mago", 2, 100));
    }
}
