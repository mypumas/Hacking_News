import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;
import com.hackingnews.model.Mesure;
import com.hackingnews.model.Vulnerabilite;
import com.mysql.jdbc.ResultSet;

class VulnerabiliteTest {

	@Test
	void testConstructeur() {
		Vulnerabilite vulnerabilite = new Vulnerabilite();
		Assert.assertNotNull(vulnerabilite);
	}
	
	@Test
	void testConstructeur1() {
		ArrayList <Criticite> listeCriticite = new ArrayList<>();	
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
		
		assertEquals(vulnerabilite.getNom(),"CryptoLocker");
		assertEquals(vulnerabilite.getDescription(),"Description CryptoLocker.");
		assertEquals(vulnerabilite.getCriticite(),listeCriticite.get(1));
		
		
	}
	
	@Test
	void testConstructeur2() {
		Criticite criticite = new Criticite("Faible","Peu de risque de propagation");
		Vulnerabilite vulnerabilite = new Vulnerabilite(2,"CryptoLocker","Description CryptoLocker.",criticite);
		
		assertEquals(vulnerabilite.getIdVulnerabilite(),2);
		assertEquals(vulnerabilite.getNom(),"CryptoLocker");
		assertEquals(vulnerabilite.getDescription(),"Description CryptoLocker.");
		assertEquals(vulnerabilite.getCriticite(),criticite);	
	}
	
	@Test
	void testConstructeur4() {	
		Criticite criticite = new Criticite("Faible","Peu de risque de propagation");
		ArrayList<Mesure> listeMesures = new ArrayList<Mesure>();
		listeMesures.add(new Mesure("Mesure 2", "Description Mesure 2",new Vulnerabilite()));
		listeMesures.add(new Mesure("Mesure 3", "Description Mesure 3",new Vulnerabilite()));
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",criticite,listeMesures);
		
		assertEquals(vulnerabilite.getNom(),"CryptoLocker");
		assertEquals(vulnerabilite.getDescription(),"Description CryptoLocker.");
		assertEquals(vulnerabilite.getCriticite(),criticite);
		assertEquals(vulnerabilite.getMesure(),listeMesures);	
	}
	
	@Test
	void testSetters() {
		Criticite criticite = new Criticite("Faible","Peu de risque de propagation");
		ArrayList<Mesure> listeMesures = new ArrayList<Mesure>();
		listeMesures.add(new Mesure("Mesure 2", "Description Mesure 2",new Vulnerabilite()));
		listeMesures.add(new Mesure("Mesure 3", "Description Mesure 3",new Vulnerabilite()));
		
		Vulnerabilite vulnerabilite = new Vulnerabilite();
		
		vulnerabilite.setIdVulnerabilite(1);
		vulnerabilite.setNom("CryptoLocker");
		vulnerabilite.setDescription("Description CryptoLocker.");
		vulnerabilite.setCriticite(criticite);
		vulnerabilite.setMesure(listeMesures);
		
		assertEquals(vulnerabilite.getIdVulnerabilite(),1);
		assertEquals(vulnerabilite.getNom(),"CryptoLocker");
		assertEquals(vulnerabilite.getDescription(),"Description CryptoLocker.");
		assertEquals(vulnerabilite.getCriticite(),criticite);
		assertEquals(vulnerabilite.getMesure(),listeMesures);
	}
	
	@Test
	void testListVulnerabilite() {
		Vulnerabilite vulnerabilite = new Vulnerabilite();
		ResultSet rs = vulnerabilite.listVulnerabilite();
		Assert.assertNotNull(rs);
	}
	
	@Test
	void testMaxId() {
		Vulnerabilite vulnerabilite = new Vulnerabilite();
		int maxId = vulnerabilite.getLastID();
		assertEquals(maxId,70);
	}
}
