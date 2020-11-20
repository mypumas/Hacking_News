package com.hackingnews.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hackingnews.controller.VulnerabiliteInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


public class Vulnerabilite implements VulnerabiliteInterface{
	private int idVulnerabilite;
	private String nom;
	private String description;
	private Criticite criticite;
	private ArrayList<Mesure> mesure = new ArrayList<Mesure>();
	
	public Vulnerabilite() {
		super();
	}
	
	public Vulnerabilite(int idVulnerabilite, String nom, String description, Criticite criticite) {
		super();
		this.idVulnerabilite = idVulnerabilite;
		this.nom = nom;
		this.description = description;
		this.criticite = criticite;
	}
	
	public Vulnerabilite(String nom, String description, Criticite criticite) {
		super();
		this.nom = nom;
		this.description = description;
		this.criticite = criticite;
	}
	
	public Vulnerabilite(String nom, String description, Criticite criticite, ArrayList<Mesure> mesure) {
		super();
		this.nom = nom;
		this.description = description;
		this.criticite = criticite;
		this.mesure = mesure;
	}
	
	public int getIdVulnerabilite() {
		return idVulnerabilite;
	}
	public void setIdVulnerabilite(int idVulnerabilite) {
		this.idVulnerabilite = idVulnerabilite;
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
	public Criticite getCriticite() {
		return criticite;
	}
	public void setCriticite(Criticite criticite) {
		this.criticite = criticite;
	}	
	public ArrayList<Mesure> getMesure() {
		return mesure;
	}
	public void setMesure(ArrayList<Mesure> mesure) {
		this.mesure = mesure;
	}

	@Override
	public void create() {
		try {
			// TODO add your handling code here:
			Connexion c= new Connexion();
			java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `vulnerabilite`(`nom`, `description`, `id_criticite`) VALUE ('"+this.getNom()+"','"+this.getDescription()+"','"+this.getCriticite().getIdCriticite()+"')");
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null,"Ajouté avec	succés","",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex); 
		}
	}
	@Override
	public void update() {
		try {
			// TODO add your handling code here:
			Connexion c = new Connexion();
			String sql = "UPDATE `vulnerabilite` SET `nom`='" + this.getNom() + "', `description`='" + this.getDescription() + "', `id_criticite` = '" + this.getCriticite().getIdCriticite() + "' WHERE id_vulnerabilite ='" + this.getIdVulnerabilite() + "';";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Modifié avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	@Override
	public void delete() {
		try {
			// TODO add your handling code here:
			Connexion c = new Connexion();
			String sql = "DELETE FROM `vulnerabilite` WHERE `id_vulnerabilite`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.setLong(1, this.getIdVulnerabilite());
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Supprimé avec succés", "", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, ex);
		}
	}
	@Override
	public ResultSet listVulnerabilite() 
	{
		Connexion c=new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM vulnerabilite");
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
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT MAX(id_vulnerabilite) as lastID FROM vulnerabilite");
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
