package starWars;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DAOFilm {
	private String bddName = "starwars";
	private String bddLogin = "root";
	private String bddPassword = "";
	private String bddIP = "localhost";
	private String bddPort = "3306";
	String strClassName = "com.mysql.jdbc.Driver";
	String bddUrl = "jdbc:mysql://" + this.bddIP + ":" + this.bddPort + "/" + this.bddName;
	Connection conn;
	Statement stLogin;

	public DAOFilm() {
		try {
			Class.forName(this.strClassName);
			this.conn = DriverManager.getConnection(this.bddUrl, this.bddLogin, this.bddPassword);
			this.stLogin = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
		}
	}

	public void Close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Lister() {
		try {
			String strQuery = "SELECT * FROM film;";
			ResultSet rsUsers = this.stLogin.executeQuery(strQuery);
			while (rsUsers.next()) {
				System.out.println("Id : " + rsUsers.getInt(1) + " Titre : " + rsUsers.getString(2)
						+ " Date de sortie : " + rsUsers.getInt(3) + " Numéro : " + rsUsers.getString(4) + " coût : "
						+ rsUsers.getInt(5) + " recette : " + rsUsers.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void AjouterFilm(int id, String Titre, String sortie, int numero, int cout, int recette) {
		try {
			String query = " insert into film (id,Titre,sortie,numero,cout,recette)" + " values (?,?,?,?,?,?);";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, Titre);
			preparedStmt.setString(3, sortie);
			preparedStmt.setInt(4, numero);
			preparedStmt.setInt(5, cout);
			preparedStmt.setInt(6, recette);
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFilm(String tableBDD, int datasId) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+datasId+";";
            System.out.println(sql);
            stLogin.executeUpdate(sql);
            System.out.println("->Suppression de la ligne "+datasId+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
	
	 public void deleteFilm(String tableBDD, film film) throws SQLException{
	        try{
	            String sql = "DELETE FROM "+tableBDD+" WHERE id="+film.getId()+";";
	            System.out.println(sql);
	            stLogin.executeUpdate(sql);
	        } catch (SQLException e) {
	            System.err.println("Autre erreur !");
	            e.printStackTrace();
	        }
	    }
	
	public ArrayList listReadingArrayList(String sqlQuery) throws SQLException{
        try{
            ResultSet datas = this.stLogin.executeQuery(sqlQuery);
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    film newFilm = new film(datas.getInt(1), datas.getString(2), datas.getString(3), 
                            datas.getInt(4), datas.getInt(5), datas.getInt(6));
                    resultDatas.add(newFilm);
                }
                conn.close();
                return resultDatas;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return null;
        }
    }
	
	public String updateFilm(film film) throws SQLException{
        String result = "Mise à jour du film non effectué.";
        try{
            String sql = "UPDATE `films` SET "
                    +"`id`="+film.getId()+","
                    +"`titre`=\""+film.getTitre()+"\","
                    +"`anneeDeSortie`=\""+film.getAnneeSortie()+"\","
                    +"`numeroEpisode`="+film.getNumeroEpisode()+","
                    +"`cout`="+film.getCout()+","
                    +"`recette`="+film.getRecette()+""
                    +" WHERE id="+film.getId()+"";
            System.out.println(sql);
            stLogin.executeUpdate(sql);
            System.out.println("->Update des datas dans la [Films] OK");
            result = "Mise à jour du film réussi.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }
	
	public void addFilm(String tableBDD, film film) throws SQLException{
        try{
            String sql = "INSERT INTO "+tableBDD+" (`titre`, `anneeDeSortie`, `numeroEpisode`, `cout`, `recette`) VALUES ";
            String sqlElements = "("
                            +"\""+film.getTitre()+"\""+","
                            +"\""+film.getAnneeSortie()+"\""+","
                            +film.getNumeroEpisode()+","
                            +film.getCout()+","
                            +film.getRecette()
                            +")";
            sql += sqlElements;
            System.out.println(sql);
            stLogin.executeUpdate(sql);
            System.out.println("->Insertion des datas dans la ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète d'ajout d'un film dans une base de donnée
     * 
     * addFilm(Film film)
     * @param film
     * @return String
     * @throws java.sql.SQLException
     */
    public String addFilm(film film) throws SQLException{
        String result = "Ajout du film non effectué.";
        try{
            String sql = "INSERT INTO films (`titre`, `anneeDeSortie`, `numeroEpisode`, `cout`, `recette`) VALUES ";
            String sqlElements = "("
                            +"\""+film.getTitre()+"\""+","
                            +"\""+film.getAnneeSortie()+"\""+","
                            +film.getNumeroEpisode()+","
                            +film.getCout()+","
                            +film.getRecette()
                            +")";
            sql += sqlElements;
            System.out.println(sql);
            stLogin.executeUpdate(sql);
            System.out.println("->Insertion des datas dans la [Films] OK");
            result = "Ajout du film réussi.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		DAOFilm co = new DAOFilm();
		co.Lister();
		co.Lister();
		co.AjouterFilm(2, "L'attaque des clones", "2002", 2, 500000, 560000);
		co.Lister();
	}

}
