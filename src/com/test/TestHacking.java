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
		listeLogiciel.add(new Logiciel("Access","Base de données Microsoft"));
		listeLogiciel.add(new Logiciel("Oracle DB","Base de données Oracle"));
		listeLogiciel.add(new Logiciel("Eclipse","Editeur Java"));
		listeLogiciel.add(new Logiciel("Notepad++","Editeur de texte GNU"));
		
		/*for(Logiciel l : listeLogiciel)
		{
			l.create();
		}*/
		
		ArrayList <Criticite> listeCriticite = new ArrayList<>();
		
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		listeCriticite.add(new Criticite("Elevée","Deconnecter les serveurs du réseau"));
		listeCriticite.add(new Criticite("Extrême","Cellule de crise activée"));
		
		//for(int i = 0; i< listeCriticite.size(); i++)
		//{
		//	listeCriticite.get(i).create();
		//	listeCriticite.get(i).setIdCriticite(listeCriticite.get(i).getLastID());  
		//}
		
		ArrayList <Vulnerabilite> listeVulnerabilite = new ArrayList<>();
		
		listeVulnerabilite.add(new Vulnerabilite("ILOVEYOU","Ce virus informatique existe depuis les années 2000 et a fait des millions de victimes à travers le monde. Néanmoins, bonne nouvelle : son mode opératoire est connu. Malgré tout, de nombreux internautes naïfs tombent encore dans le piège de ce virus. Comment ? En ouvrant une pièce jointe intitulée « Love-Letter-for-you.txt.vbs » dans leur boîte mails. A peine ouverte, cette pièce jointe libère le virus informatique. Dès lors, tous les fichiers se trouvant sur votre ordinateur sont modifiés et les hackers ont accès à votre carnet d’adresses. Ils s’en serviront pour envoyer des e-mails à vos contacts, puis très vite votre appareil souffrira d’un ralentissement.",listeCriticite.get(1)));
		listeVulnerabilite.add(new Vulnerabilite("CryptoLocker","Les « rançongiciels » ou ransomwares sont des virus qui sévissent depuis 2013. Parmi eux, l’un des virus informatiques les plus dangereux : CryptoLocker. Il peut s’infiltrer via un e-mail, sur un site de téléchargement ou un site de partage de fichiers. Dès que vous ouvrez le fichier contaminé, un écran apparaît vous informant que votre ordinateur est bloqué et que, pour le débloquer, vous devrez payer une rançon. Si vous ne le faites pas dans le temps imparti, les hackers vous indiquent que toutes les données de votre PC seront détruites.",listeCriticite.get(1)));
		listeVulnerabilite.add(new Vulnerabilite("JIGSAW","Fonctionnant comme CryptoLocker, JIGSAW semble encore plus dangereux. Il ne laisse qu’une heure à sa victime pour payer la rançon sous peine de voir disparaître toutes les données de son ordinateur. Avec ce virus, elles seront détruites très rapidement. En effet, en 72 maximum, les disques seront vidés ! ",listeCriticite.get(2)));
		listeVulnerabilite.add(new Vulnerabilite("PETYA","Voici un autre ransomware. Celui-ci cible les entreprises et menace de paralyser totalement le fonctionnement des appareils et le réseau informatique des victimes. Pour ce faire, il crypte les données, ainsi que les fichiers systèmes. Les hackers sont pleinement conscients du pouvoir qu’ils ont sur les entreprises et des dégâts qu’ils peuvent faire, c’est pourquoi ils demandent une rançon très élevée.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("LOCKY","Ce virus cible certains fichiers spécifiques sur les disques durs. En 2018, nombreux sont les internautes français et allemands qui ont été victimes de ce virus. Lui aussi crypte les fichiers, vous empêchant totalement d’accéder à votre ordinateur. Il supprime également vos sauvegardes et bloque toute tentative de récupération. En conséquence, les données de l’appareil sont immobilisées jusqu’à ce que vous payiez une rançon de plusieurs milliers d’euros.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Heartbleed","Protéger son ordinateur avec un mot de passe ou un code n’est pas suffisant face à Heartbleed. En effet, ce virus informatique est le roi de la récupération de mots de passe. Il réussit à récupérer petit à petit des fragments de vos codes, jusqu’à les reconstituer entièrement.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Freak","FREAK est un virus qui arrive à déceler la moindre de faille de sécurité du protocole TLS. Il s’attaquera tout spécialement à votre compte en banque. Ce virus crypte votre PC pour y avoir accès et y installer des logiciels malveillants espions. Une fois installés, toutes vos communications seront surveillées. C’est ainsi que les pirates arrivent à prendre possession de votre compte bancaire et vous vous en doutez, à voler votre argent.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Stuxnet","8ème dans la liste des virus informatiques les plus dangereux en 2020, Stuxnet a été découvert en 2010. Il est utilisé par la NSA en collaboration avec l’unité 8200 : les renseignements de l’Armée de défense d’Israël. Ce virus leur a notamment permis de détruire des centrifugeuses d’enrichissement d’uranium localisées en Iran. Lorsqu’il est installé, il est capable de modifier la vitesse de fonctionnement des machines, jusqu’à les détruire. En effet, c’est cette même technique qui a été utilisée pour faire tomber en panne les centrifugeuses destinées, semble-t-il, à la création d’une bombe nucléaire en Iran.",listeCriticite.get(3)));
		listeVulnerabilite.add(new Vulnerabilite("Regin","Créée par la National Security Agency et son homologue britannique, le Government Communications Headquarters, Regin est une plateforme de cyber-espionnage. Elle a pour objectif de collecter des données et prendre le contrôle total des ordinateurs ciblés. Ce virus permet aux hackers de récupérer des mots de passe, d’espionner des conversations téléphoniques, ainsi que de récupérer des e-mails. Regin est actif depuis 2008 et a déjà été utilisé pour espionner les institutions européennes, les entreprises de télécommunication et certaines sociétés privées.",listeCriticite.get(0)));
		listeVulnerabilite.add(new Vulnerabilite("Waledac","Waledac est un virus qui vous envoie les mêmes spams à longueur de temps. Il a notamment servi à l’envoi massif de spams pour du viagra. Ces envois sont dus aux botnets (réseaux de robots). Dans sa période la plus faste, Waledac a envoyé près de 5 millions de messages par jour. S’il semble que ce virus en particulier a été éradiqué en 2010 par Microsoft, il a servi a créer de nouveaux botnets encore plus redoutables. Ces derniers enverraient de nombreux spams provenant de divers serveurs.",listeCriticite.get(1)));
		
		//for(int i = 0; i< listeVulnerabilite.size(); i++)
		//{
		//	listeVulnerabilite.get(i).create();
		//	listeVulnerabilite.get(i).setIdVulnerabilite(listeVulnerabilite.get(i).getLastID());  
		//}
		
		ArrayList<Mesure> listeMesures = new ArrayList<Mesure>();
		
		listeMesures.add(new Mesure("Mesure vs ILOVEYOU", "Si vous avez exécuté le fichier attaché au mail intitulé I Love You, vous avez été infecté. Le virus a modifié tous vos fichiers d''extensions vbs, vbe, js, jse, css, wsh, sct, hta, jpg, jpeg, mp3 et mp2. L''extension .vbs est désormais attachée à ces fichiers. Il vous faut rechercher et effacer tous les .vbs qui datent du 4/05/2000 sur tous les disques locaux. Les fichiers originaux sont perdus. Pensez à effacer en particulier le fichier LOVE-LETTER-FOR-YOU.TXT.vbs.\r\n" + 
				"\r\n" + 
				"Effacez aussi les fichiers LOVE-LETTER-FOR-YOU.HTM (ils contiennent un activeX qui fait la même chose que le vbs) si jamais vous arrivez sur cette page, refusez impérativement l''installation de l''activeX.\r\n" + 
				"\r\n" + 
				"Pour les autres fichiers : si vous aviez le programme mirc32 (un logiciel de chat sur Internet) sur votre poste (fichiers : mirc32.exe, mlink32.exe, mirc.ini, mirc.hlp), le fichier script.ini a été modifié. Il faut le supprimer.\r\n" + 
				"\r\n" + 
				"En ce qui concerne la base de registres de Windows, quelques modifications sont nécessaires.\r\n" + 
				"\r\n" + 
				"Lancez REGEDIT à partir de Windows :\r\n" + 
				"\r\n" + 
				"HKEY_LOCAL_MACHINE\\Software\\Microsoft\\Windows\r\n" + 
				"\r\n" + 
				"\\CurrentVersion\\Run\\\r\n" + 
				"\r\n" + 
				"retirez ce qui pointe sur MSKernel32.vbs", listeVulnerabilite.get(0)));
		listeMesures.add(new Mesure("Mesure Générale ransomware", "Mettez à jour votre antivirus et le logiciel de protection de vos terminaux – ces solutions peuvent aider à détecter certains types de ransomware et les empêcher de chiffrer vos fichiers.\r\n" + 
				"Évitez de vous faire avoir par les attaques de phishing – les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents – il est bien plus simple et rapide de récupérer vos documents à partir d’une sauvegarde que de les déchiffrer si vous avez été victime d’une attaque de ransomware.\r\n" + 
				"Adoptez un modèle de zéro confiance / moindre privilège – le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut écrire. Un modèle de moindre privilège limite cet accès à ce qui est absolument nécessaire.\r\n" + 
				"Surveillez les activités sur les fichiers et le comportement des utilisateurs pour détecter, signaler et faire face à toute activité de ransomware potentielle.",
				listeVulnerabilite.get(1)));
		listeMesures.add(new Mesure("Mesure Générale ransomware", "Mettez à jour votre antivirus et le logiciel de protection de vos terminaux – ces solutions peuvent aider à détecter certains types de ransomware et les empêcher de chiffrer vos fichiers.\r\n" + 
				"Évitez de vous faire avoir par les attaques de phishing – les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents – il est bien plus simple et rapide de récupérer vos documents à partir d’une sauvegarde que de les déchiffrer si vous avez été victime d’une attaque de ransomware.\r\n" + 
				"Adoptez un modèle de zéro confiance / moindre privilège – le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut écrire. Un modèle de moindre privilège limite cet accès à ce qui est absolument nécessaire.\r\n" + 
				"Surveillez les activités sur les fichiers et le comportement des utilisateurs pour détecter, signaler et faire face à toute activité de ransomware potentielle.",
				listeVulnerabilite.get(2)));
		listeMesures.add(new Mesure("Mesure Générale ransomware", "Mettez à jour votre antivirus et le logiciel de protection de vos terminaux – ces solutions peuvent aider à détecter certains types de ransomware et les empêcher de chiffrer vos fichiers.\r\n" + 
				"Évitez de vous faire avoir par les attaques de phishing – les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents – il est bien plus simple et rapide de récupérer vos documents à partir d’une sauvegarde que de les déchiffrer si vous avez été victime d’une attaque de ransomware.\r\n" + 
				"Adoptez un modèle de zéro confiance / moindre privilège – le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut écrire. Un modèle de moindre privilège limite cet accès à ce qui est absolument nécessaire.\r\n" + 
				"Surveillez les activités sur les fichiers et le comportement des utilisateurs pour détecter, signaler et faire face à toute activité de ransomware potentielle.",
				listeVulnerabilite.get(3)));
		listeMesures.add(new Mesure("Mesure Suppression CryptoLocker", "Pour supprimer CryptoLocker de votre ordinateur, il vous suffit de lancer un programme antivirus fiable tel qu’Avast Antivirus Gratuit."
				+ " Il analysera votre ordinateur à la recherche de toute trace de programme malveillant, y compris les ransomwares comme CryptoLocker, et le supprimera de votre machine."
				, listeVulnerabilite.get(1)));
		listeMesures.add(new Mesure("Mesure Générale ransomware", "Mettez à jour votre antivirus et le logiciel de protection de vos terminaux – ces solutions peuvent aider à détecter certains types de ransomware et les empêcher de chiffrer vos fichiers.\r\n" + 
				"Évitez de vous faire avoir par les attaques de phishing – les e-mails de phishing constituent le principal vecteur de propagation du ransomware.\r\n" + 
				"Conservez des sauvegardes de vos documents – il est bien plus simple et rapide de récupérer vos documents à partir d’une sauvegarde que de les déchiffrer si vous avez été victime d’une attaque de ransomware.\r\n" + 
				"Adoptez un modèle de zéro confiance / moindre privilège – le ransomware peut seulement infecter les dossiers dans lesquels un utilisateur peut écrire. Un modèle de moindre privilège limite cet accès à ce qui est absolument nécessaire.\r\n" + 
				"Surveillez les activités sur les fichiers et le comportement des utilisateurs pour détecter, signaler et faire face à toute activité de ransomware potentielle.",
				listeVulnerabilite.get(4)));
		
		listeMesures.add(new Mesure("Mesure Suppression Locky", "Windows 8 – Windows 10\r\n" + 
				"\r\n" + 
				"Appuyez sur Alimentation sur l’écran de démarrage de Windows\r\n" + 
				"Appuyez et maintenez la touche majuscule enfoncée et cliquez sur redémarrer\r\n" + 
				"Choisissez Dépanner à Options avancées àParamètres de démarrage et cliquer sur Redémarrer.\r\n" + 
				"Lorsque cela charge, sélectionnez Activer Mode sans échec avec Invite de commande dans la liste des Paramètres de démarrage.\r\n" + 
				"Restaurer les fichiers du système et les paramètres\r\n" + 
				"\r\n" + 
				"Lorsque le mode invite de commande charge, entrez la restauration de cd et appuyez sur entrée\r\n" + 
				"Entrez rstrui.exe\r\n" + 
				"Appuyez sur entrée\r\n" + 
				"Dans la fenêtre qui apparaît, cliquez sur « suivant »\r\n" + 
				"Sélectionner un des Point de restauration qui sont disponibles avant que virus Locky ait infiltré votre système puis cliquer sur “Suivant”.\r\n" + 
				"Pour démarrer la Restauration du système, cliquer sur “Oui”.", listeVulnerabilite.get(4)));
		
		listeMesures.add(new Mesure("Outil suppression Stuxnet", "Le 15 juillet 2010, Siemens met à disposition de ses clients un outil capable de détecter et de supprimer le ver27.\r\n" + 
				"\r\n" + 
				"Le 2 août 2010, Microsoft annonce le Bulletin de sécurité MS10-04628.\r\n" + 
				"\r\n" + 
				"Le 19 août 2010, un outil de suppression est mis à disposition par FSB Security Labs en France29.\r\n" + 
				"\r\n" + 
				"Le 8 octobre 2010, un outil de suppression est mis à disposition par BitDefender.", listeVulnerabilite.get(5)));
		
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
