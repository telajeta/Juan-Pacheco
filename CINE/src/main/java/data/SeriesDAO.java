package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.Series;

public class SeriesDAO {
    private static final String SQL_CREATE="INSERT INTO cines(nombre, director, cantMinutos, precio, capitulos) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM cines";
    private static final String SQL_READ_BY_ID="SELECT * FROM cines WHERE idcines = ?";
    private static final String SQL_UPDATE_PRECIO="UPDATE cines SET precio = ? WHERE idcines = ?";
    private static final String SQL_UPDATE_CAPITULOS="UPDATE cines SET capitulos = ? WHERE idcines = ?";
    private static final String SQL_DELETE="DELETE FROM cines WHERE idcines = ?";
    
 
    public List<Series> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Series serie = null;
        List<Series> series = new ArrayList();  //java 7 minuto 53

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int idcines = rs.getInt(1);
                String nombre = rs.getString(2);
                String director = rs.getString(3);
                int cantMinutos = rs.getInt(4);
                double precio = rs.getDouble(5);
                int capitulos = rs.getInt(6);

                serie = new Series(idcines, nombre, director, cantMinutos, precio, capitulos);

                series.add(serie);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return series;
    }
    
    
    public Series findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Series serie = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int idcines = rs.getInt(1);
                String nombre = rs.getString(2);
                String director = rs.getString(3);
                int cantMinutos = rs.getInt(4);
                double precio = rs.getDouble(5);
                int capitulos = rs.getInt(6);

                serie = new Series(idcines, nombre, director, cantMinutos, precio, capitulos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return serie;
    }
    
    
        public int insert(Series serie){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, serie.getNombre());
            stmt.setString(2, serie.getDirector());
            stmt.setInt(3, serie.getCantMinutos());
            stmt.setDouble(4, serie.getPrecio());
            stmt.setInt(5, serie.getCapitulos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updatePrecio(Series serie){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, serie.getPrecio());
            stmt.setInt(2, serie.getIdcines());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateCapitulos(Series serie){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_CAPITULOS);
            stmt.setInt(1, serie.getCapitulos());
            stmt.setInt(2, serie.getIdcines());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int deleteSerie(Series serie){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, serie.getIdcines());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
}
