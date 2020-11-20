package com.hackingnews.model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hackingnews.controller.LogicielInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Logiciel implements LogicielInterface {
	private int idLogiciel;
	private String nom;
	private String description;
	
	public Logiciel() {
		super();
	}
	
	public Logiciel(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	
	public Logiciel(int idLogiciel, String nom, String description) {
		super();
		this.idLogiciel = idLogiciel;
		this.nom = nom;
		this.description = description;
	}

	public int getIdLogiciel() {
		return idLogiciel;
	}

	public void setIdLogiciel(int idLogiciel) {
		this.idLogiciel = idLogiciel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
			java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `logiciel`(`nom`, `description`) VALUE ('"+this.getNom()+"','"+this.getDescription()+"')");
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null,"Ajouté avec	succés","",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex); 
		}
	}

	@Override
	public ResultSet listLogiciel()
	{
		Connexion c=new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM logiciel");
			pst.executeQuery();
		    rs = (ResultSet) pst.executeQuery();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;

	}
}
