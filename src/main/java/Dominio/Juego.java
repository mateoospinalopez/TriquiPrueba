/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author mateo
 */
public class Juego {

    private int identificadorTablero;
    private Date fecha;
    private int ganador;
    private Jugador[] jugadores;
    private Tablero tableroJuego;
    private boolean turno;

    public Juego() {
        this.tableroJuego = new Tablero();
        this.jugadores = new Jugador[2];
        this.turno = true;
        this.jugadores[0] = new Jugador("Jugador 1");
        this.jugadores[1] = new Jugador("Jugador 2");
    }

    /*
    Inserta un simnbolo en una pisicion 
     */
    public void insertarSimbolo(int fila, int columna) {
        if (turno) {
            tableroJuego.getTablero()[fila][columna] = tableroJuego.getX();
        } else {
            tableroJuego.getTablero()[fila][columna] = tableroJuego.getO();
        }
    }

    /**
     * Mostramos el turno actual
     */
    public String mostrarTurnoJugadorActual() {

        if (this.turno) {
           return " jugador 1";
        } else {
            return " jugador 2";
        }

    }

    public void cambiarTurno() {
        this.setTurno(!this.turno);
    }

    /*
    --------------------------------------------------------------------------------
     */
    /**
     * Indica si hay un ganador en una linea
     *
     *
     * @return simbolo ganador, sino lo hay devuelve el de por defecto
     */
    public char coincidenciaLinea() {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < tableroJuego.getTablero().length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = tableroJuego.getTablero()[i][0];
            if (simbolo != tableroJuego.getVacio()) {
                for (int j = 1; j < tableroJuego.getTablero()[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tableroJuego.getTablero()[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return tableroJuego.getVacio();

    }

    public char coincidenciaColumna() {

        char simbolo;
        boolean coincidencia;

        for (int j = 0; j < tableroJuego.getTablero().length; j++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = tableroJuego.getTablero()[0][j];
            if (simbolo != tableroJuego.getVacio()) {
                for (int i = 1; i < tableroJuego.getTablero()[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tableroJuego.getTablero()[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return tableroJuego.getVacio();

    }

    public char coincidenciaDiagonal() {

        char simbolo;
        boolean coincidencia = true;

        //Diagonal principal
        simbolo = tableroJuego.getTablero()[0][0];
        if (simbolo != tableroJuego.getVacio()) {
            for (int i = 1; i < tableroJuego.getTablero().length; i++) {
                //sino coincide ya no habra ganador en esta fila
                if (simbolo != tableroJuego.getTablero()[i][i]) {
                    coincidencia = false;
                }
            }

            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }

        }

        //Diagonal inversa
        simbolo = tableroJuego.getTablero()[0][2];
        if (simbolo != tableroJuego.getVacio()) {
            for (int i = 1, j = 1; i < tableroJuego.getTablero().length; i++, j--) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != tableroJuego.getTablero()[i][j]) {
                    coincidencia = false;
                }
            }

            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return tableroJuego.getVacio();

    }

    /**
     * La partida acaba cuando la matriz esta llena o hay un ganador
     *
     * @return
     */
    public boolean finPartida() {

        if (tableroJuego.tableroLleno()
                || coincidenciaLinea() != tableroJuego.getVacio()
                || coincidenciaColumna() != tableroJuego.getVacio()
                || coincidenciaDiagonal() != tableroJuego.getVacio()) {
            return true;
        }

        return false;
    }

    /*
    Regresa N si es no hay ganador
     */
    public char ganador() {

        char simbolo = coincidenciaLinea();

        if (simbolo != this.tableroJuego.getVacio()) {
            return simbolo;
        }

        simbolo = coincidenciaColumna();

        if (simbolo != this.tableroJuego.getVacio()) {
            return simbolo;
        }

        simbolo = coincidenciaDiagonal();

        if (simbolo != this.tableroJuego.getVacio()) {
            return simbolo;
        }

        return 'N';//N de Null
    }

    public char obtenerSimbolo(int fila, int columna) {
        return this.tableroJuego.getTablero()[fila][columna];
    }

    /*
    -----------------------------------------------
    Getters 
     */

    public int getIdentificadorTablero() {
        return identificadorTablero;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getGanador() {
        return ganador;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Tablero getTableroJuego() {
        return tableroJuego;
    }

    public boolean isTurno() {
        return turno;
    }

    /**
     * @param tableroJuego the tableroJuego to set
     */
    public void setTableroJuego(Tablero tableroJuego) {
        this.tableroJuego = tableroJuego;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

}
