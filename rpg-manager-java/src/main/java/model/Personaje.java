package model;

/**
 * @Breider
 */

public class Personaje {
     //Atributos
    private String nombre;
    private String clase;
    private int nivel;
    private int puntosDeVida;
    
    //Constructor
    public Personaje(String nombre, String clase, int nivel, int puntosDeVida){
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
    }
    
    // Getters
    public String getNombre(){
        return nombre;
    }
    public String getClase(){
        return clase;
    }
    public int getNivel(){
        return nivel;
    }
    public int getPuntosDeVida(){
        return puntosDeVida;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setClase(String clase){
        this.clase = clase;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public void setPuntosDeVida(int puntosDeVida){
        this.puntosDeVida = puntosDeVida;
    }
}
