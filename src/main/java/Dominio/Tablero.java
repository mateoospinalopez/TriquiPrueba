/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Arrays;

/**
 *
 * @author mateo
 */
public class Tablero {

    private int identificador;
    private char[][] tablero;
    private final char X;
    private final char O;
    private final char vacio;

    public Tablero() {
        this.identificador = identificador;
        this.tablero = new char[3][3];
        this.O = 'O';
        this.X = 'X';
        this.vacio = '-';
        this.inicializarTablero();
    }

    public void inicializarTablero() {
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }

    }

    /*
    Se mira si aun quedan espacios vacios en la matriz
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == this.vacio) {
                    return false;
                }
            }
        }

        return true;

    }

    /*
    Revisa si existe un valor en una posicion especifica
     */
    public boolean hayValorPosicion(int fila, int columna) {
        return tablero[fila][columna] != vacio;
    }

    public boolean validarPosicion(int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length;
    }

    public void mostrarTablero() {

        for (int i = 0; i < this.tablero.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.tablero.length; j++) {
                System.out.print(this.tablero[i][j]);
                if (j != this.tablero.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the tablero
     */
    public char[][] getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public char getX() {
        return X;
    }

    public char getO() {
        return O;
    }

    public char getVacio() {
        return vacio;
    }

    @Override
    public String toString() {
        return "Tablero{" + "identificador=" + identificador + ", tablero=" + Arrays.toString(tablero) + ", X=" + X + ", O=" + O + ", vacio=" + vacio + '}';
    }

}
