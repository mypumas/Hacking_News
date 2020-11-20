package com.hackingnews.model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;

public class MailThread implements Runnable {

	private ServletContext context;

	public MailThread(ServletContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		System.out.println("Sending Mail ... " + new Date());

		try {
			this.sendMail();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Finish Sending");
	}

	private void sendMail() throws IOException {

		// Creation liste adresse Mail TO
		Abonnes a = new Abonnes();
		ResultSet rs = a.listAbonnes();
		ArrayList<String> listeAdresse = new ArrayList<String>();

		try {
			while (rs.next()) {
				listeAdresse.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Récupération dernière vulnérabilité pour envoi
		Vulnerabilite v = new Vulnerabilite();
		int id = v.getLastID();
		v.setIdVulnerabilite(id);

		String subject = "Alerte nouveau virus : " + v.getNom();
		String message = "<h1> Alerte nouveau virus : " + v.getNom()+ "</h1>" + "<p>" + v.getDescription()+ "</p>";
//				+ "<p>Criticité : " + v.getCriticite().getNiveau()+ "</p>";
		SendMail.sendHtml(listeAdresse, subject, message);

	}

}