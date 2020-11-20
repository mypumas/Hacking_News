package com.hackingnews.model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hackingnews.controller.MesureInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Mesure implements MesureInterface {

	private int idMesure;
	private String nomMesure, descriptionMesure;
	private Vulnerabilite vulnerabilite;

	public Mesure() {
		super();
	}
	
	public Mesure(int idMesure, String nomMesure, String descriptionMesure, Vulnerabilite vulnerabilite) {
		super();
		this.idMesure = idMesure;
		this.nomMesure = nomMesure;
		this.descriptionMesure = descriptionMesure;
		this.vulnerabilite = vulnerabilite;
	}
	
	public Mesure(String nomMesure, String descriptionMesure, Vulnerabilite vulnerabilite) {
		super();
		this.nomMesure = nomMesure;
		this.descriptionMesure = descriptionMesure;
		this.vulnerabilite = vulnerabilite;
	}

	@Override
	public void create() {
		try {
			Connexion c = new Connexion();
			java.sql.PreparedStatement pst = c.conn
					.prepareStatement("INSERT INTO `mesure`(`nom`, `description`, `id_vulnerabilite`) VALUES" + " ('"
							+ this.getNomMesure() + "','" + this.getDescriptionMesure() + "','"
							+ this.getVulnerabilite().getIdVulnerabilite() + "')");
			pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Mesure ajoutée avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public ResultSet listMesure() 
	{
		Connexion c = new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM mesure");
			pst.executeQuery();
			rs = (ResultSet) pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void update() {
		try {
			Connexion c = new Connexion();
			String sql = "UPDATE `mesure` SET `nom`='" + this.getNomMesure() + "' ,`description`='"
					+ this.getDescriptionMesure() + "' ,`id_vulnerabilite`='" + this.getVulnerabilite().getIdVulnerabilite()
					+ "' WHERE `id_mesure`='" + this.getIdMesure() + "';";
			java.sql.PreparedStatement pst = c.conn.prepareStatement(sql);
			pst.executeUpdate();
			;
			// JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public void delete() {
		try {
			Connexion c = new Connexion();
			String sql = "DELETE FROM `mesure` WHERE `id_mesure`=?"; 
			java.sql.PreparedStatement pst = c.conn.prepareStatement(sql);
			pst.setInt(1, this.getIdMesure());
			pst.execute();
			// JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public int getLastID() {
		Connexion c=new Connexion();
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT MAX(id_mesure) as lastID FROM mesure");
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
	
	public int getIdMesure() {
		return idMesure;
	}

	public void setIdMesure(int idMesure) {
		this.idMesure = idMesure;
	}

	public String getNomMesure() {
		return nomMesure;
	}

	public void setNomMesure(String nomMesure) {
		this.nomMesure = nomMesure;
	}

	public String getDescriptionMesure() {
		return descriptionMesure;
	}

	public void setDescriptionMesure(String descriptionMesure) {
		this.descriptionMesure = descriptionMesure;
	}

	public Vulnerabilite getVulnerabilite() {
		return vulnerabilite;
	}

	public void setVulnerabilite(Vulnerabilite vulnerabilite) {
		this.vulnerabilite = vulnerabilite;
	}

}
