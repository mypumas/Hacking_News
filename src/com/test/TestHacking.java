package com.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hackingnews.model.Abonnes;
import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;
import com.hackingnews.model.Mesure;
import com.hackingnews.model.Vulnerabilite;
import com.mysql.jdbc.ResultSet;

public class TestHacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Logiciel> listeLogiciel = new ArrayList<>();
		
		listeLogiciel.add(new Logiciel("Word","Editeur de texte Microsoft")); 
		listeLogiciel.add(new Logiciel("Excel","Tableur Microsoft"));
		listeLogiciel.add(new Logiciel("Access","Base de donn�es Microsoft"));
		listeLogiciel.add(new Logiciel("Oracle DB","Base de donn�es Oracle"));
		listeLogiciel.add(new Logiciel("Eclipse","Editeur Java"));
		listeLogiciel.add(new Logiciel("Notepad++","Editeur de texte GNU"));
		
		/*for(Logiciel l : listeLogiciel)
		{
			l.create();
		}*/
		
		ArrayList <Criticite> listeCriticite = new ArrayList<>();
		
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Mod�r�e","Faire v�rifier le logiciel"));
		listeCriticite.add(new Criticite("Elev�e","Deconnecter les serveurs du r�seau"));
		listeCriticite.add(new Criticite("Extr�me","Cellule de crise activ�e"));
		
		//for(int i = 0; i< listeCriticite.size(); i++)
		//{
		//	listeCriticite.get(i).create();
		//	listeCriticite.get(i).setIdCriticite(listeCriticite.get(i).getLastID());  
		//}
		
		ArrayList <Vulnerabilite> listeVulnerabilite = new ArrayList<>();
		
		listeVulnerabilite.add(new Vulnerabilite("ILOVEYOU","Ce virus informatique existe depuis les ann�es 2000 et a fait des millions de victimes � travers le monde. N�anmoins, bonne nouvelle : son mode op�ratoire est connu. Malgr� tout, de nombreux internautes na�fs tombent encore dans le pi�ge de ce virus. Comment ? En ouvrant une pi�ce jointe intitul�e � Love-Letter-for-you.txt.vbs � dans leur bo�te mails. A peine ouverte, cette pi�ce jointe lib�re le virus informatique. D�s lors, tous les fichiers se trouvant sur votre ordinateur sont modifi�s et les hackers ont acc�s � votre carnet d�adresses. Ils s�en serviront pour envoyer des e-mails � vos contacts, puis tr�s vite votre appareil souffrira d�un ralentissement.",listeCriticite.get(1)));
		listeVulnerabilite.add(new Vulnerabilite("CryptoLocker","Les � ran�ongiciels � ou ransomwares sont des virus qui s�vissent depuis 2013. Parmi eux, l�un des virus informatiques les plus dangereux : CryptoLocker. Il peut s�infiltrer via un e-mail, sur un site de t�l�chargement ou un site de partage de fichiers. D�s que vous ouvrez le fichier contamin�, un �cran appara�t vous informant que votre ordinateur est bloqu� et que, pour le d�bloquer, vous devrez payer une ran�on. Si vous ne le faites pas dans le temps imparti, les hackers vous indiquent que toutes les donn�es de votre PC seront d�truites.",listeCriticite.get(1)));
		listeVulnerabilite.add(new Vulnerabilite("JIGSAW","Fonctionnant comme CryptoLocker, JIGSAW semble encore plus dangereux. Il ne laisse qu�une heure � sa victime pour payer la ran�on sous peine de voir dispara�tre toutes les donn�es de son ordinateur. Avec ce virus, elles seront d�truites tr�s rapidement. En effet, en 72 maximum, les disques seront vid�s ! ",listeCriticite.get(2)));
		listeVulnerabilite.add(new Vulnerabilite("PETYA","Voici un autre ransomware. Celui-ci cible les entreprises et menace de paralyser totalement le fonctionnement des appareils et le r�seau informatique des victimes. Pour ce faire, il crypte les donn�es, ainsi que les fichiers syst�mes. Les hackers sont pleinement conscients du pouvoir qu�ils ont sur les entreprises et des d�g�ts qu�ils peuvent faire, c�est pourquoi ils demandent une ran�on tr�s �lev�e.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("LOCKY","Ce virus cible certains fichiers sp�cifiques sur les disques durs. En 2018, nombreux sont les internautes fran�ais et allemands qui ont �t� victimes de ce virus. Lui aussi crypte les fichiers, vous emp�chant totalement d�acc�der � votre ordinateur. Il supprime �galement vos sauvegardes et bloque toute tentative de r�cup�ration. En cons�quence, les donn�es de l�appareil sont immobilis�es jusqu�� ce que vous payiez une ran�on de plusieurs milliers d�euros.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Heartbleed","Prot�ger son ordinateur avec un mot de passe ou un code n�est pas suffisant face � Heartbleed. En effet, ce virus informatique est le roi de la r�cup�ration de mots de passe. Il r�ussit � r�cup�rer petit � petit des fragments de vos codes, jusqu�� les reconstituer enti�rement.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Freak","FREAK est un virus qui arrive � d�celer la moindre de faille de s�curit� du protocole TLS. Il s�attaquera tout sp�cialement � votre compte en banque. Ce virus crypte votre PC pour y avoir acc�s et y installer des logiciels malveillants espions. Une fois install�s, toutes vos communications seront surveill�es. C�est ainsi que les pirates arrivent � prendre possession de votre compte bancaire et vous vous en doutez, � voler votre argent.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Stuxnet","8�me dans la liste des virus informatiques les plus dangereux en 2020, Stuxnet a �t� d�couvert en 2010. Il est utilis� par la NSA en collaboration avec l�unit� 8200 : les renseignements de l�Arm�e de d�fense d�Isra�l. Ce virus leur a notamment permis de d�truire des centrifugeuses d�enrichissement d�uranium localis�es en Iran. Lorsqu�il est install�, il est capable de modifier la vitesse de fonctionnement des machines, jusqu�� les d�truire. En effet, c�est cette m�me technique qui a �t� utilis�e pour faire tomber en panne les centrifugeuses destin�es, semble-t-il, � la cr�ation d�une bombe nucl�aire en Iran.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Regin","Cr��e par la National Security Agency et son homologue britannique, le Government Communications Headquarters, Regin est une plateforme de cyber-espionnage. Elle a pour objectif de collecter des donn�es et prendre le contr�le total des ordinateurs cibl�s. Ce virus permet aux hackers de r�cup�rer des mots de passe, d�espionner des conversations t�l�phoniques, ainsi que de r�cup�rer des e-mails. Regin est actif depuis 2008 et a d�j� �t� utilis� pour espionner les institutions europ�ennes, les entreprises de t�l�communication et certaines soci�t�s priv�es.",listeCriticite.get(0)));
		listeVulnerabilite.add(new Vulnerabilite("Waledac","Waledac est un virus qui vous envoie les m�mes spams � longueur de temps. Il a notamment servi � l�envoi massif de spams pour du viagra. Ces envois sont dus aux botnets (r�seaux de robots). Dans sa p�riode la plus faste, Waledac a envoy� pr�s de 5 millions de messages par jour. S�il semble que ce virus en particulier a �t� �radiqu� en 2010 par Microsoft, il a servi a cr�er de nouveaux botnets encore plus redoutables. Ces derniers enverraient de nombreux spams provenant de divers serveurs.",listeCriticite.get(1)));
		
		//for(int i = 0; i< listeVulnerabilite.size(); i++)
		//{
		//	listeVulnerabilite.get(i).create();
		//	listeVulnerabilite.get(i).setIdVulnerabilite(listeVulnerabilite.get(i).getLastID());  
		//}
		
		ArrayList<Mesure> listeMesures = new ArrayList<Mesure>();
		
		listeMesures.add(new Mesure("Mesure vs ILOVEYOU", "Si vous avez ex�cut� le fichier attach� au mail intitul� I Love You, vous avez �t� infect�. Le virus a modifi� tous vos fichiers d''extensions vbs, vbe, js, jse, css, wsh, sct, hta, jpg, jpeg, mp3 et mp2. L''extension .vbs est d�sormais attach�e � ces fichiers. Il vous faut rechercher et effacer tous les .vbs qui datent du 4/05/2000 sur tous les disques locaux. Les fichiers originaux sont perdus. Pensez � effacer en particulier le fichier LOVE-LETTER-FOR-YOU.TXT.vbs.\r\n" + 
				"\r\n" + 
				"Effacez aussi les fichiers LOVE-LETTER-FOR-YOU.HTM (ils contiennent un activeX qui fait la m�me chose que le vbs) si jamais vous arrivez sur cette page, refusez imp�rativement l''installation de l''activeX.\r\n" + 
				"\r\n" + 
				"Pour les autres fichiers : si vous aviez le programme mirc32 (un logiciel de chat sur Internet) sur votre poste (fichiers : mirc32.exe, mlink32.exe, mirc.ini, mirc.hlp), le fichier script.ini a �t� modifi�. Il faut le supprimer.\r\n" + 
				"\r\n" + 
				"En ce qui concerne la base de registres de Windows, quelques modifications sont n�cessaires.\r\n" + 
				"\r\n" + 
				"Lancez REGEDIT � partir de Windows :\r\n" + 
				"\r\n" + 
				"HKEY_LOCAL_MACHINE\\Software\\Microsoft\\Windows\r\n" + 
				"\r\n" + 
				"\\CurrentVersion\\Run\\\r\n" + 
				"\r\n" + 
				"retirez ce qui pointe sur MSKernel32.vbs", listeVulnerabilite.get(0)));
		listeMesures.add(new Mesure("Mesure G�n�rale ransomware", "Mettez � jour votre antivirus et le logiciel de protection de vos terminaux � ces solutions peuvent aider � d�tecter certains types de ransomware et les emp�cher de chiffrer vos fichiers.\r\n" + 
				"�vitez de vous faire avoir par les attaques de phishing � les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents � il est bien plus simple et rapide de r�cup�rer vos documents � partir d�une sauvegarde que de les d�chiffrer si vous avez �t� victime d�une attaque de ransomware.\r\n" + 
				"Adoptez un mod�le de z�ro confiance / moindre privil�ge � le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut �crire. Un mod�le de moindre privil�ge limite cet acc�s � ce qui est absolument n�cessaire.\r\n" + 
				"Surveillez les activit�s sur les fichiers et le comportement des utilisateurs pour d�tecter, signaler et faire face � toute activit� de ransomware potentielle.",
				listeVulnerabilite.get(1)));
		listeMesures.add(new Mesure("Mesure G�n�rale ransomware", "Mettez � jour votre antivirus et le logiciel de protection de vos terminaux � ces solutions peuvent aider � d�tecter certains types de ransomware et les emp�cher de chiffrer vos fichiers.\r\n" + 
				"�vitez de vous faire avoir par les attaques de phishing � les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents � il est bien plus simple et rapide de r�cup�rer vos documents � partir d�une sauvegarde que de les d�chiffrer si vous avez �t� victime d�une attaque de ransomware.\r\n" + 
				"Adoptez un mod�le de z�ro confiance / moindre privil�ge � le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut �crire. Un mod�le de moindre privil�ge limite cet acc�s � ce qui est absolument n�cessaire.\r\n" + 
				"Surveillez les activit�s sur les fichiers et le comportement des utilisateurs pour d�tecter, signaler et faire face � toute activit� de ransomware potentielle.",
				listeVulnerabilite.get(2)));
		listeMesures.add(new Mesure("Mesure G�n�rale ransomware", "Mettez � jour votre antivirus et le logiciel de protection de vos terminaux � ces solutions peuvent aider � d�tecter certains types de ransomware et les emp�cher de chiffrer vos fichiers.\r\n" + 
				"�vitez de vous faire avoir par les attaques de phishing � les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents � il est bien plus simple et rapide de r�cup�rer vos documents � partir d�une sauvegarde que de les d�chiffrer si vous avez �t� victime d�une attaque de ransomware.\r\n" + 
				"Adoptez un mod�le de z�ro confiance / moindre privil�ge � le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut �crire. Un mod�le de moindre privil�ge limite cet acc�s � ce qui est absolument n�cessaire.\r\n" + 
				"Surveillez les activit�s sur les fichiers et le comportement des utilisateurs pour d�tecter, signaler et faire face � toute activit� de ransomware potentielle.",
				listeVulnerabilite.get(3)));
		listeMesures.add(new Mesure("Mesure Suppression CryptoLocker", "Pour supprimer CryptoLocker de votre ordinateur, il vous suffit de lancer un programme antivirus fiable tel qu�Avast Antivirus Gratuit."
				+ " Il analysera votre ordinateur � la recherche de toute trace de programme malveillant, y compris les ransomwares comme CryptoLocker, et le supprimera de votre machine."
				, listeVulnerabilite.get(1)));
		listeMesures.add(new Mesure("Mesure G�n�rale ransomware", "Mettez � jour votre antivirus et le logiciel de protection de vos terminaux � ces solutions peuvent aider � d�tecter certains types de ransomware et les emp�cher de chiffrer vos fichiers.\r\n" + 
				"�vitez de vous faire avoir par les attaques de phishing � les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents � il est bien plus simple et rapide de r�cup�rer vos documents � partir d�une sauvegarde que de les d�chiffrer si vous avez �t� victime d�une attaque de ransomware.\r\n" + 
				"Adoptez un mod�le de z�ro confiance / moindre privil�ge � le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut �crire. Un mod�le de moindre privil�ge limite cet acc�s � ce qui est absolument n�cessaire.\r\n" + 
				"Surveillez les activit�s sur les fichiers et le comportement des utilisateurs pour d�tecter, signaler et faire face � toute activit� de ransomware potentielle.",
				listeVulnerabilite.get(4)));
		
		listeMesures.add(new Mesure("Mesure Suppression Locky", "Windows 8 � Windows 10\r\n" + 
				"\r\n" + 
				"Appuyez sur Alimentation sur l��cran de d�marrage de Windows\r\n" + 
				"Appuyez et maintenez la touche majuscule enfonc�e et cliquez sur red�marrer\r\n" + 
				"Choisissez D�panner � Options avanc�es �Param�tres de d�marrage et cliquer sur Red�marrer.\r\n" + 
				"Lorsque cela charge, s�lectionnez Activer Mode sans �chec avec Invite de commande dans la liste des Param�tres de d�marrage.\r\n" + 
				"Restaurer les fichiers du syst�me et les param�tres\r\n" + 
				"\r\n" + 
				"Lorsque le mode invite de commande charge, entrez la restauration de cd et appuyez sur entr�e\r\n" + 
				"Entrez rstrui.exe\r\n" + 
				"Appuyez sur entr�e\r\n" + 
				"Dans la fen�tre qui appara�t, cliquez sur � suivant �\r\n" + 
				"S�lectionner un des Point de restauration qui sont disponibles avant que virus Locky ait infiltr� votre syst�me puis cliquer sur �Suivant�.\r\n" + 
				"Pour d�marrer la Restauration du syst�me, cliquer sur �Oui�.", listeVulnerabilite.get(4)));
		
		listeMesures.add(new Mesure("Outil suppression Stuxnet", "Le 15 juillet 2010, Siemens met � disposition de ses clients un outil capable de d�tecter et de supprimer le ver27.\r\n" + 
				"\r\n" + 
				"Le 2 ao�t 2010, Microsoft annonce le Bulletin de s�curit� MS10-04628.\r\n" + 
				"\r\n" + 
				"Le 19 ao�t 2010, un outil de suppression est mis � disposition par FSB Security Labs en France29.\r\n" + 
				"\r\n" + 
				"Le 8 octobre 2010, un outil de suppression est mis � disposition par BitDefender.", listeVulnerabilite.get(5)));
		
		//for(Mesure m : listeMesures)
		//	m.create();
		
		ArrayList<Abonnes> listeAbonnes = new ArrayList<Abonnes>();
		
		listeAbonnes.add(new Abonnes("Gomes", "Julien", "julien.gomes@cimpa.com","",""));
		listeAbonnes.add(new Abonnes("Cramard", "Carolyn", "carolyn.cramard@cimpa.com","",""));
		listeAbonnes.add(new Abonnes("Tahir", "Virginie", "virginie.tahir@cimpa.com","",""));
		listeAbonnes.add(new Abonnes("Gaudry", "Romain", "romain.gaudry@cimpa.com","",""));
		
		//for(Abonnes a : listeAbonnes)
		//	a.create();	
		
		try {
			Vulnerabilite v = new Vulnerabilite();
			ResultSet result = v.listVulnerabilite();
			
			while(result.next())
			{
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3)); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Criticite criticite = new Criticite();
			
		ResultSet result;
		
		try {
			result = criticite.listCriticite();
			while(result.next())
			{
					System.out.println(result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
