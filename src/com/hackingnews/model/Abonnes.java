package com.hackingnews.model;

import java.sql.SQLException;

import com.hackingnews.controller.AbonnesInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Abonnes implements AbonnesInterface{
	
	private int idAbonne;
	private String nom, prenom, email, login, password;
	
	public int getIdAbonne() {
		return idAbonne;
	}
	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Abonnes(int idAbonne, String nom, String prenom, String email) {
		super();
		this.idAbonne = idAbonne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	public Abonnes(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public Abonnes() {
		super();
	}
	
	public Abonnes(String nom, String prenom, String email, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	
	@Override
	public void create() {
		try {
			Connexion c = new Connexion(); 
			java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `abonnes`(`nom`, `prenom`, `email`, `login`, `password`) VALUES ('"
							+ this.getNom() + "','" + this.getPrenom() + "','" + this.getEmail() + "','" + this.getLogin() + "','" + this.getPassword() +"')");
			statement.executeUpdate();  
			// JOptionPane = popup a supprimer sur du jsp car on n'utilise pas de popup
			//JOptionPane.showMessageDialog(null, "Ajouté avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, ex);   //message d'erreur dans un popup
			System.out.println(ex);
		}
		
	}
	@Override
	public void delete() {
		try {
			Connexion c = new Connexion();
			// modifier le nom de la table
			// String sql = "DELETE FROM `table` WHERE `id`=?";
			String sql = "DELETE FROM `abonnes` WHERE `id_abonne`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			// mod la valeur de l'id
			// statement.setInt(1, valeur_de_id);
			statement.setInt(1, this.getIdAbonne());
			statement.execute();
			System.out.println("Supprimé avec succés");
			//JOptionPane.showMessageDialog(null, "Supprimé avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
		}
			//JOptionPane.showMessageDialog(null, ex);
		}
		
	@Override
	public void update() {
		try { 
			Connexion c = new Connexion();			
			String sql = "UPDATE `abonnes` SET `nom`='" + this.getNom() + "' ,`prenom`='" + this.getPrenom() + "', `email`='" + this.getEmail() + "', `login`='" + this.getLogin() + "', `email`='" + this.getEmail() + "'  WHERE `id_abonne`='" + this.getIdAbonne() +"';";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.executeUpdate();
			;
			System.out.println("Modifié avec succés");
			//JOptionPane.showMessageDialog(null, "Modifié avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	@Override
	public ResultSet listAbonnes() {
		Connexion c=new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try 
		{			
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM  abonnes");
			pst.executeQuery();
			rs = (ResultSet) pst.executeQuery();			
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return rs;
	}
	
	public int getLastID() {
		Connexion c=new Connexion();
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT MAX(id_abonne) as lastID FROM abonnes");
			pst.executeQuery();
			ResultSet rs = (ResultSet) pst.executeQuery();
			rs.next();

			return rs.getInt("lastID");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public Abonnes authentification() throws SQLException {
		// TODO Auto-generated method stub
		Connexion c=new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM abonnes WHERE login ='" + this.getLogin() + "' and password = '" + this.getPassword() + "';");
		pst.executeQuery();
		ResultSet rs = (ResultSet) pst.executeQuery();
		
		if(rs.next()) {
			Abonnes abonne = new Abonnes();
			abonne.setIdAbonne(rs.getInt("id_abonne"));
			abonne.setNom(rs.getString("nom"));
			abonne.setPrenom(rs.getString("prenom"));
			abonne.setEmail(rs.getString("email"));
			abonne.setLogin(rs.getString("login"));
			abonne.setPassword(rs.getString("password"));
			
			return abonne;
		}
		
		return null;
	}

}
