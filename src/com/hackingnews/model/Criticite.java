package com.hackingnews.model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hackingnews.controller.CriticiteInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Criticite implements CriticiteInterface {
	private int idCriticite;
	private String niveau;
	private String description;
	
	public Criticite() {
		super();
	}
	
	public Criticite(int idCriticite, String niveau, String description) {
		super();
		this.idCriticite = idCriticite;
		this.niveau = niveau;
		this.description = description;
	}
	
	public Criticite(String niveau, String description) {
		super();
		this.niveau = niveau;
		this.description = description;
	}

	public int getIdCriticite() {
		return idCriticite;
	}

	public void setIdCriticite(int idCriticite) {
		this.idCriticite = idCriticite;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void create() {
		try {
			// TODO add your handling code here:
			Connexion c= new Connexion();
			java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `criticite`(`niveau`, `description`) VALUE ('"+this.getNiveau()+"','"+this.getDescription()+"')");
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null,"Ajouté avec	succés","",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex); 
		}
	}
	
	@Override
	public ResultSet listCriticite()
	{
		Connexion c=new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM criticite");
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
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT MAX(id_criticite) as lastID FROM criticite");
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
		
}
