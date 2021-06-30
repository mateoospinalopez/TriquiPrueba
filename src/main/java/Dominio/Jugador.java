/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author mateo
 */
public class Jugador {
    private int identificadorJugador;
    private String nombre;
    private int puntaje;

    public Jugador() {
    }
    

    public Jugador(int identificador, String nombre) {
        this.identificadorJugador = identificador;
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    
    

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificadorJugador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificadorJugador = identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }


    @Override
    public String toString() {
        return "Jugador{" + "identificador=" + identificadorJugador + ", nombre=" + nombre + ", puntaje=" + puntaje + '}';
    }
    
    
}
