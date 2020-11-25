package com.hackingnews.model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hackingnews.controller.AbonnementInterface;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.*;

public class Abonnement implements AbonnementInterface {

	private Abonnes abonne;
	private int statut ;
	private String format, frequence;

	public Abonnement(Abonnes abonne, String format, String frequence, int statut) {
		super();
		this.abonne = abonne;
		this.format = format;
		this.frequence = frequence;
		this.statut = statut;
	}

	public Abonnement() {
		super();
	}

	public Abonnes getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonnes abonne) {
		this.abonne = abonne;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	@Override
	public void create() {
		try {
			Connexion c = new Connexion();
			java.sql.PreparedStatement pst = c.conn
					.prepareStatement("INSERT INTO `abonnement`(`id_abonne`, `format`, `frequence`, `statut`) VALUES" + " ('"
							+ this.getAbonne().getIdAbonne() + "','" + this.getFormat() + "','"
							+ this.getFrequence() + "','" + this.getStatut()+ "')");
			pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Abonnement ajoutée avec succés", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public ResultSet listAbonnement() 
	{
		Connexion c = new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM abonnement");
			pst.executeQuery();
		    rs = (ResultSet) pst.executeQuery();
			return rs;
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
			String sql = "UPDATE `abonnement` SET `id_abonne`='" + this.getAbonne().getIdAbonne() + "' ,`format`='"
					+ this.getFormat() + "' ,`frequence`='" + this.getFrequence() + "' ,`statut`='" + this.getStatut()
					+ "' WHERE `id_abonne`='" + this.getAbonne().getIdAbonne() + "';";
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
			String sql = "DELETE FROM `abonnement` WHERE `id_abonne`=?"; 
			java.sql.PreparedStatement pst = c.conn.prepareStatement(sql);
			pst.setInt(1, this.getAbonne().getIdAbonne());
			pst.execute();
			// JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, ex);
		}

	}

}
