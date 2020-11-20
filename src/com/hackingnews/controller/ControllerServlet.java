package com.hackingnews.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackingnews.model.Abonnement;
import com.hackingnews.model.Abonnes;
import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;
import com.hackingnews.model.Mesure;
import com.hackingnews.model.SendMail;
import com.hackingnews.model.Vulnerabilite;
import com.hackingnews.model.VulnerabiliteLogiciel;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Vulnerabilite> listeVulnerabilite = new ArrayList<>();
	private ArrayList<Criticite> listeCriticite = new ArrayList<>();
	private ArrayList<VulnerabiliteLogiciel> listeVulnerabiliteLogiciel = new ArrayList<>();
	private ArrayList<Abonnes> listeAbonnes = new ArrayList<>();
	private ArrayList<Mesure> listeMesure = new ArrayList<>();
	private ArrayList<Logiciel> listeLogiciel = new ArrayList<>();
	
	private ArrayList<Abonnement> listeAbonnement = new ArrayList<>();
	
	
	public void init(ServletConfig config) throws ServletException {
		Vulnerabilite vulnerabilite  = new Vulnerabilite();
		Criticite criticite = new Criticite();
		Abonnes abonnes = new Abonnes();
		Abonnement abonnement = new Abonnement();
		Mesure mesure = new Mesure();
		Logiciel logiciel = new Logiciel();
		VulnerabiliteLogiciel vulnerabiliteLogiciel = new VulnerabiliteLogiciel();
		
		
		
		
		ResultSet result;
		
		try {
			result = abonnes.listAbonnes();
			while(result.next())
			{
					listeAbonnes.add(new Abonnes(Integer.parseInt(result.getString(1)),result.getString(2),result.getString(3),result.getString(4)));
			}
			try {
				result = criticite.listCriticite();
				while(result.next())
				{
						listeCriticite.add(new Criticite(Integer.parseInt(result.getString(1)),result.getString(2),result.getString(3)));
				}
				try {
					result = vulnerabilite.listVulnerabilite();
					while(result.next())
					{			
						for(Criticite c : listeCriticite) {
							if(c.getIdCriticite() == Integer.parseInt(result.getString(4))) {
								listeVulnerabilite.add(new Vulnerabilite(Integer.parseInt(result.getString(1)),result.getString(2),result.getString(3),c));
								break;
							}	
						}
					}
					try {
						result = mesure.listMesure();
						while(result.next())
						{			
							for(Vulnerabilite v : listeVulnerabilite) {
								if(v.getIdVulnerabilite() == Integer.parseInt(result.getString(4))) {
									listeMesure.add(new Mesure(Integer.parseInt(result.getString(1)),result.getString(2),result.getString(3),v));
									break;
								}	
							}
						}
						result = logiciel.listLogiciel();
						while(result.next())
						{
							listeLogiciel.add(new Logiciel(Integer.parseInt(result.getString(1)),result.getString(2),result.getString(3)));	
						}	
						result = vulnerabiliteLogiciel.listVulnerabiliteLogiciel();
						while(result.next())
						{			
							for(Vulnerabilite v : listeVulnerabilite) {
								if(v.getIdVulnerabilite() == Integer.parseInt(result.getString(1))) 
								{	
									for(Logiciel l : listeLogiciel) {
										if(l.getIdLogiciel() == Integer.parseInt(result.getString(2))) 
										{
											listeVulnerabiliteLogiciel.add(new VulnerabiliteLogiciel(v,l,result.getString(3)));
											break;
										}
									}	
								}	
							}
						}
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());	
		String action = request.getParameter("action");
		if(action== null)
		{
			request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
			//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			//request.setAttribute("listeCriticite",listeCriticite);
			request.getRequestDispatcher("/WEB-INF/vues/hackingnews.jsp").forward(request,response);
		}
		else {
			HttpSession session;
			int idVulnerabilite = 0;
			int idCriticite= 0;
			switch(action)
			{			
				case "editer" :
					idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
				    idCriticite = Integer.parseInt(request.getParameter("criticite"));
				    				    
				    for(int i=0; i< listeVulnerabilite.size(); i++) 
					{
						if(listeVulnerabilite.get(i).getIdVulnerabilite() == idVulnerabilite)
						{
							listeVulnerabilite.get(i).setNom(request.getParameter("nom"));
							listeVulnerabilite.get(i).setDescription(request.getParameter("description"));
							for(Criticite c : listeCriticite) {
								if(c.getIdCriticite() == idCriticite) {
									listeVulnerabilite.get(i).setCriticite(c);
									break;
								}	
							}
							listeVulnerabilite.get(i).update();
							break;
						}
					}
					request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.setAttribute("listeCriticite",listeCriticite);
					request.getRequestDispatcher("/WEB-INF/vues/adminVulnerabilite.jsp").forward(request,response);
				break;
				
				case "deleteVulnerabilite" :

					idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
					for(int i=0; i< listeVulnerabilite.size(); i++) 
					{
						if(listeVulnerabilite.get(i).getIdVulnerabilite() == idVulnerabilite)
						{
							listeVulnerabilite.get(i).delete();
							listeVulnerabilite.remove(i);
							break;
						}
					}
					request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.getRequestDispatcher("/WEB-INF/vues/adminVulnerabilite.jsp").forward(request,response);
					
				break;
				case "deleteAbonne" :

					int idAbonne = Integer.parseInt(request.getParameter("idAbonne"));
					for(int i=0; i< listeAbonnes.size(); i++) 
					{
						if(listeAbonnes.get(i).getIdAbonne() == idAbonne)
						{
							listeAbonnes.get(i).delete();
							listeAbonnes.remove(i);
							break;
						}
					}
					request.setAttribute("listeAbonnes",listeAbonnes);
					request.getRequestDispatcher("/WEB-INF/vues/adminAbonne.jsp").forward(request,response);
					
				break;
				case "deleteMesure" :

					int idMesure = Integer.parseInt(request.getParameter("idMesure"));
					for(int i=0; i< listeMesure.size(); i++) 
					{
						if(listeMesure.get(i).getIdMesure() == idMesure)
						{
							listeMesure.get(i).delete();
							listeMesure.remove(i);
							break;
						}
					}
					request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/adminMesure.jsp").forward(request,response);
					
				break;
				case "historique" :
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					//request.setAttribute("listeCriticite",listeCriticite);
					request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/historique.jsp").forward(request,response);
				break;
				case "vulnarebiliteLogiciel" :
					request.setAttribute("idLogiciel",request.getParameter("idLogiciel"));
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					//request.setAttribute("listeCriticite",listeCriticite);
					//request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/historique.jsp").forward(request,response);
				break;
				case "vulnarebiliteCriticite" :
					request.setAttribute("idCriticite",request.getParameter("idCriticite"));
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					//request.setAttribute("listeCriticite",listeCriticite);
					//request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/historique.jsp").forward(request,response);
				break;
				case "detail" :
					
					idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
					int idLogiciel = Integer.parseInt(request.getParameter("idLogiciel"));
					//String nom = request.getParameter("nom");
					//String description = request.getParameter("description");
					//String criticite = request.getParameter("criticite");
					
					request.setAttribute("idVulnerabilite",idVulnerabilite);
					request.setAttribute("idLogiciel",idLogiciel);
					//request.setAttribute("nom",nom);
					//request.setAttribute("description",description);
					//request.setAttribute("criticite",criticite);
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/detailVulnerabilite.jsp").forward(request,response);
				break;
				case "adminVulnerabilite" :
					request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.setAttribute("listeCriticite",listeCriticite);
					request.getRequestDispatcher("/WEB-INF/vues/adminVulnerabilite.jsp").forward(request,response);
				break;
				case "adminMesure" :
					request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					request.setAttribute("listeMesure",listeMesure);
					request.getRequestDispatcher("/WEB-INF/vues/adminMesure.jsp").forward(request,response);
				break;
				case "adminAbonnes" :
					request.setAttribute("listeAbonnes",listeAbonnes);
					request.getRequestDispatcher("/WEB-INF/vues/adminAbonne.jsp").forward(request,response);
				break;
				case "deconnexion" :
					session=request.getSession();
					session.invalidate();
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					request.getRequestDispatcher("/WEB-INF/vues/hackingnews.jsp").forward(request,response);
				break;
			}
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.getWriter().append("RESULT " + request.getParameter("idVulnaribilite") );
		response.getWriter().append("RESULT " + request.getParameter("TEST") );
		
		if(request.getParameter("connection") != null) 
		{
			Abonnes abonne = new Abonnes(request.getParameter("login"),request.getParameter("password"));
			try {
				abonne = abonne.authentification();
				HttpSession session=request.getSession();
				if(abonne != null)
				{
					session.setAttribute("id", abonne.getIdAbonne());
					session.setAttribute("nom", abonne.getNom());
					session.setAttribute("prenom", abonne.getPrenom());
					session.setAttribute("email", abonne.getEmail());
					session.setAttribute("login", abonne.getLogin());
					session.setAttribute("password", abonne.getPassword());
					
					request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
					//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
					//request.setAttribute("listeCriticite",listeCriticite);
					request.getRequestDispatcher("/WEB-INF/vues/hackingnews.jsp").forward(request,response);
				}
				else {
					session.setAttribute("erreur", "erreur");
					response.sendRedirect("erreur.jsp");
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("abonnement") != null) 
		{
			String nom = request.getParameter("nomAbonne");
			String prenom = request.getParameter("prenomAbonne");
			String email = request.getParameter("email");
			String frequence = request.getParameter("frequence");
			String format = request.getParameter("format");
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Abonnes abonne = new Abonnes(nom,prenom,email,login,password);
			abonne.create();
			abonne.setIdAbonne(abonne.getLastID());
			listeAbonnes.add(abonne);
			Abonnement abonnement = new Abonnement(abonne,format,frequence,1);
			abonnement.create();
			
			//request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			//request.setAttribute("listeCriticite",listeCriticite);
			request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
			request.getRequestDispatcher("/WEB-INF/vues/hackingnews.jsp").forward(request,response);	
		}
		else if(request.getParameter("creerVulnerabilite") != null)
		{
			Vulnerabilite v = new Vulnerabilite();
			
			v.setNom(request.getParameter("nom"));
			v.setDescription(request.getParameter("description"));
			for(Criticite c : listeCriticite) {
				if(c.getIdCriticite() == Integer.parseInt(request.getParameter("criticite"))) {
					v.setCriticite(c);
					break;
				}	
			}
			v.create();
			v.setIdVulnerabilite(v.getLastID());
			listeVulnerabilite.add(v);
			request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			request.setAttribute("listeCriticite",listeCriticite);
			
			// Envoi mail
			ArrayList<String> recipient = new ArrayList<String>();
			for (Abonnes a : listeAbonnes) {
				recipient.add(a.getEmail());
			}

			String subject = "Alerte virus : " + v.getNom();
			String content = "<h1>Nouveau virus détecté :" + v.getNom() + "<h1/>" + "<p>" + v.getDescription() + "</p>";

			// String resultMessage = "";

			try {
				SendMail.sendHtml(recipient, subject, content);

				// resultMessage = "The e-mail was sent successfully";
			} catch (Exception ex) {
				ex.printStackTrace();
				// resultMessage = "There were an error: " + ex.getMessage();
			}
			// Fin envoi Mail 

			 

			
			request.getRequestDispatcher("/WEB-INF/vues/adminVulnerabilite.jsp").forward(request,response);
		}
		else if(request.getParameter("modifierVulnerabilite") != null)
		{
			int idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
			int idCriticite = Integer.parseInt(request.getParameter("criticite"));
		    				    
		    for(int i=0; i< listeVulnerabilite.size(); i++) 
			{
				if(listeVulnerabilite.get(i).getIdVulnerabilite() == idVulnerabilite)
				{
					listeVulnerabilite.get(i).setNom(request.getParameter("nom"));
					listeVulnerabilite.get(i).setDescription(request.getParameter("description"));
					for(Criticite c : listeCriticite) {
						if(c.getIdCriticite() == idCriticite) {
							listeVulnerabilite.get(i).setCriticite(c);
							break;
						}	
					}
					listeVulnerabilite.get(i).update();
					break;
				}
			}
			request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			request.setAttribute("listeCriticite",listeCriticite);
			request.getRequestDispatcher("/WEB-INF/vues/adminVulnerabilite.jsp").forward(request,response);	
		}
		else if(request.getParameter("ajouterMesure") != null) 
		{
			int idVulnerabilite = Integer.parseInt(request.getParameter("idIdVulnerabiliteMesure"));
			Mesure mesure = null;
			for(int i=0; i< listeVulnerabilite.size(); i++) 
			{
				if(listeVulnerabilite.get(i).getIdVulnerabilite() == idVulnerabilite)
				{
					mesure = new Mesure(request.getParameter("nomMesure"),request.getParameter("descriptionMesure"),listeVulnerabilite.get(i));					
					break;
				}
			}
			mesure.create();
			mesure.setIdMesure(mesure.getLastID());
			listeMesure.add(mesure);
			request.setAttribute("idVulnerabilite",idVulnerabilite);
			request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			request.setAttribute("listeMesure",listeMesure);
			request.getRequestDispatcher("/WEB-INF/vues/adminMesure.jsp").forward(request,response);	
		}
		else if(request.getParameter("modifierMesure") != null)
		{
			int idMesure = Integer.parseInt(request.getParameter("idMesure"));
			int idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
		    				    
		    for(int i=0; i< listeMesure.size(); i++) 
			{
				if(listeMesure.get(i).getIdMesure() == idMesure)
				{
					listeMesure.get(i).setNomMesure(request.getParameter("nomMesure"));
					listeMesure.get(i).setDescriptionMesure(request.getParameter("descriptionMesure"));
					for(Vulnerabilite v : listeVulnerabilite) {
						if(v.getIdVulnerabilite() == idVulnerabilite) {
							listeMesure.get(i).setVulnerabilite(v);
							break;
						}	
					}
					listeMesure.get(i).update();
					break;
				}
			}
		    request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			request.setAttribute("listeMesure",listeMesure);
			request.getRequestDispatcher("/WEB-INF/vues/adminMesure.jsp").forward(request,response);	
		}
		else if(request.getParameter("modifierAbonne") != null)
		{
			int idAbonne = Integer.parseInt(request.getParameter("idAbonne"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String format = request.getParameter("format");
			String frequence = request.getParameter("frequence");
		    				    
		    for(int i=0; i< listeAbonnes.size(); i++) 
			{
				if(listeAbonnes.get(i).getIdAbonne() == idAbonne)
				{
					listeAbonnes.get(i).setNom(nom);
					listeAbonnes.get(i).setPrenom(prenom);
					listeAbonnes.get(i).setEmail(email);		
					listeAbonnes.get(i).update();
					Abonnement abonnement = new Abonnement(listeAbonnes.get(i),format,frequence,1);
					abonnement.update();
					break;
				}
			}
		    
		   
			
			request.setAttribute("listeAbonnes",listeAbonnes);
			request.getRequestDispatcher("/WEB-INF/vues/adminAbonne.jsp").forward(request,response);	
		}
		else if(request.getParameter("action") != null)
		{
			int idVulnerabilite = Integer.parseInt(request.getParameter("idVulnerabilite"));
		    				    
			request.setAttribute("idVulnerabilite",idVulnerabilite);
		    request.setAttribute("listeVulnerabilite",listeVulnerabilite);
			request.setAttribute("listeMesure",listeMesure);
			request.getRequestDispatcher("/WEB-INF/vues/adminMesure.jsp").forward(request,response);	
		}
		/*else if(request.getParameter("deconnexion") != null)
		{
			HttpSession session=request.getSession();
			session.invalidate();
			request.setAttribute("listeVulnerabiliteLogiciel",listeVulnerabiliteLogiciel);
			request.getRequestDispatcher("/WEB-INF/vues/hackingnews.jsp").forward(request,response);
		 }*/
	}
}
