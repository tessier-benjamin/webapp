package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {

	public static void main(String[] arg) {
		try {
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName = "Starwars";
			String login = "root";
			String motdepasse = "";
			String strUrl = "jdbc:mysql://localhost:3306/" +  dbName+"?autoReconnect=true&useSSL=false";

			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			String strInsert = "INSERT INTO film (id, Titre, sortie, numero, cout, recette) VALUES (1,'Star wars 1','1977',1,41968448,6161464);";
			Statement stAddUser = conn.createStatement();  
			stAddUser.executeUpdate(strInsert);
			System.out.println("fin");

			conn.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non charg? !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("autre erreur !");
			e.printStackTrace();

		}
	}
	
}
