/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */
public class JugadorJDBC {
        private static final String SQL_SELECT = "SELECT id_jugador, nombre, puntaje FROM jugador";
    private static final String SQL_INSERT = "INSERT INTO jugador(nombre, puntaje) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE jugador SET nombre=?, puntaje=? WHERE id_jugador = ?";
    private static final String SQL_DELETE = "DELETE FROM jugador WHERE id_jugador=?";
    
    public List<Jugador> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jugador jugador = null;
        List<Jugador> jugadores = new ArrayList<Jugador>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_jugador = rs.getInt("id_jugador");
                String nombre = rs.getString("nombre");
                int puntaje = rs.getInt("puntaje");
                
                jugador = new Jugador();
                jugador.setIdentificador(id_jugador);
                jugador.setNombre(nombre);
                jugador.setPuntaje(puntaje);
                
                jugadores.add(jugador);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return jugadores;
    }
    
    public int insert(Jugador jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jugador.getNombre());
            stmt.setInt(2, jugador.getPuntaje());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(Jugador jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jugador.getNombre());
            stmt.setInt(2, jugador.getPuntaje());
            stmt.setInt(3, jugador.getIdentificador());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Jugador jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jugador.getIdentificador());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
}
