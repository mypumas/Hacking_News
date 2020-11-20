package com.hackingnews.model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hackingnews.controller.VulnerabiliteLogicielInterface;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class VulnerabiliteLogiciel implements VulnerabiliteLogicielInterface {
	private Vulnerabilite vulnerabilite;
	private Logiciel logiciel;
	private String date;
	
	public VulnerabiliteLogiciel() {
		super();
	}
	
	public VulnerabiliteLogiciel(Vulnerabilite vulnerabilite, Logiciel logiciel, String date) {
		super();
		this.vulnerabilite = vulnerabilite;
		this.logiciel = logiciel;
		this.date = date;
	}
	
	public Vulnerabilite getVulnerabilite() {
		return vulnerabilite;
	}
	public void setVulnerabilite(Vulnerabilite vulnerabilite) {
		this.vulnerabilite = vulnerabilite;
	}
	public Logiciel getLogiciel() {
		return logiciel;
	}
	public void setLogiciel(Logiciel logiciel) {
		this.logiciel = logiciel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public void create() {
		try {
			// TODO add your handling code here:
			Connexion c= new Connexion();
			java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `vulnerabilite_logiciel`(`id_vulnerabilite`, `id_logiciel`, `date`) VALUE ('"+this.getVulnerabilite().getIdVulnerabilite()+"','"+this.getLogiciel().getIdLogiciel()+"','"+this.getDate()+"')");
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null,"Ajouté avec	succés","",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex); 
		}
	}
	@Override
	public void delete() {
		try {
			// TODO add your handling code here:
			Connexion c = new Connexion();
			String sql = "DELETE FROM `vulnerabilite_logiciel` WHERE `id_vulnerabilite`=? and `id_logiciel`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.setLong(1, this.getVulnerabilite().getIdVulnerabilite());
			statement.setLong(2, this.getLogiciel().getIdLogiciel());
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Supprimé avec succés", "", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public ResultSet listVulnerabiliteLogiciel()
	{
		Connexion c=new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM vulnerabilite_logiciel order by date DESC");
			pst.executeQuery();
			rs = (ResultSet) pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
