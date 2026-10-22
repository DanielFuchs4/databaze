import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

void main() throws SQLException {

    String URL = "jdbc:mysql://localhost:3306/cviceni_rpghra";
    String USER = "root";
    String PASSWORD = "";

    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

    String prikazINSERT = "INSERT INTO zamestnanci (jmeno, prijmeni, plat) VALUES (?, ?, ?)";
    try (PreparedStatement insertStmt = conn.prepareStatement(prikazINSERT)) {
        insertStmt.setString(1, "Lucie");
        insertStmt.setString(2, "Dvořáková");
        insertStmt.setInt(3, 35000);
        int pocetRadek = insertStmt.executeUpdate();
        System.out.println("Počet přidaných řádků: " + pocetRadek);
    }
    catch (SQLException e) {
        System.err.println("Problém s databází.");}



}
