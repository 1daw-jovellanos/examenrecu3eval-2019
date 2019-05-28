package recut911;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjercicioBasesDatos {

    @SuppressWarnings("empty-statement")
    public static int aumentarPuntos(String campanna, int importeMinimo, int numPuntos) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
            return -1;
        }
        int filas = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/./gestiventa", "sa", "sa")) {;

            String SQL = "UPDATE cliente set puntos= puntos+?, utilimacamp=?"
                    + "WHERE (SELECT sum(cantidad*importe) from ventas where cod_cliente=cliente.cod)>=?";

            PreparedStatement stmt;
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, numPuntos);
            stmt.setString(2, campanna);
            stmt.setInt(3, importeMinimo);
            filas = stmt.executeUpdate();
                                           
        } catch (SQLException ex) {
            return -1;
        }
        return filas;

    }
}
