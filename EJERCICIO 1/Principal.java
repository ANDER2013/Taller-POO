//EJERICIO 1) GESTION DE EMPLEADOS
//INTEGRANTES: Anderstone Paccha, David Merino, Rodrigo Seraquive

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
    public static void main(String[] args) {
        
        Empleado emp1 = new Gerente("David");
        Empleado emp2 = new Desarrollador("Rodrigo");
        
        guardar(emp1, 40);
        guardar(emp2, 40);
        
    }
    
    public static void guardar(Empleado emp,int horas){
        String url = "jdbc:sqlite:empresas.db";
        
        try(Connection conn = DriverManager.getConnection(url)) {
            
            String sql = "CREATE TABLE IF NOT EXISTS empleados (" + 
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "nombre TEXT, rol TEXT, salario REAL)";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //Insertar los datos
            PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO empleados(nombre,rol, salario) VALUES(?,?,?)");
            
            pstmt.setString(1, ((EmpleadoBase) emp).getNombre());
            pstmt.setString(2, emp.Rol());
            pstmt.setDouble(3, emp.calcularSalario(horas));
            pstmt.executeUpdate();
            
            System.out.println("Empleado guardado: " + ((EmpleadoBase)emp).getNombre());
        } catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
