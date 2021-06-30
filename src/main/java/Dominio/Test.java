/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Datos.JugadorJDBC;
import java.util.List;

/**
 *
 * @author mateo
 */
public class Test {
    public static void main(String[] args) {
//        Tablero t= new Tablero();
//        t.inicializarTablero();
//       for (int i = 0; i < t.getTablero().length; i++) {
//             System.out.print("|");
//            for (int j = 0; j <t.getTablero()[i].length ; j++) {
//                System.out.print(t.getTablero()[i][j]);
//                if(j!=t.getTablero().length-1)System.out.print("|");
//            }
//             System.out.println("|");
//        }
JugadorJDBC jugadordbc= new JugadorJDBC();
Jugador jugador1=new Jugador("Ruperto");
jugadordbc.insert(jugador1);
List<Jugador> jugadores= jugadordbc.select();
for(Jugador jugador:jugadores){
    System.out.println("Jugador: "+jugador);
}
    }
}
