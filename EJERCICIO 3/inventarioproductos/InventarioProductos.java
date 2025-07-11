//EJERCICIO 3) INVENTARIO DE PRODUCTOS
//INTEGRANTES: Anderstone Paccha, David Merino, Rodrigo Seraquive

package inventarioproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventarioProductos {
    public static void main(String[] args) {
        System.out.println("INVENTARIO DE PRODUCTOS - SQLITE");

        Producto p1 = new Electronico("Laptop HP", 950.00);
        Producto p2 = new Ropa("Camisa Blanca", 30.00);

        guardarProducto(p1);
        guardarProducto(p2);
        mostrarProductos();

        System.out.println("--- FIN DEL PROGRAMA ---");
    }

    public static void guardarProducto(Producto prod) {
        String url = "jdbc:sqlite:productos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String sqlCrear = "CREATE TABLE IF NOT EXISTS productos (" +
                              "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "tipo TEXT, nombre TEXT, precio REAL)";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCrear);

            String sqlInsertar = "INSERT INTO productos(tipo, nombre, precio) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertar);
            pstmt.setString(1, prod.tipo());
            pstmt.setString(2, prod.getNombre());
            pstmt.setDouble(3, prod.getPrecio());
            pstmt.executeUpdate();

            System.out.println("Guardado: " + prod.getNombre() + " - " + prod.mostrarPrecio());

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void mostrarProductos() {
        String url = "jdbc:sqlite:productos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String sqlSelect = "SELECT * FROM productos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect);

            System.out.println("\n--- PRODUCTOS EN LA BASE DE DATOS ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                                   rs.getString("tipo") + " - " +
                                   rs.getString("nombre") + " - $" +
                                   rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR: " + e.getMessage());
        }
    }
}
