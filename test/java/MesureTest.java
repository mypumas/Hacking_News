import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;
import com.hackingnews.model.Mesure;
import com.hackingnews.model.Vulnerabilite;
import com.mysql.jdbc.ResultSet;

class MesureTest {
	
	@Test
	void testConstructeur() {
		Mesure mesure = new Mesure();
		Assert.assertNotNull(mesure);
	}
	
	@Test
	void testConstructeur1() {
		ArrayList <Criticite> listeCriticite = new ArrayList<>();
		
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		listeCriticite.add(new Criticite("Elevée","Deconnecter les serveurs du réseau"));
		listeCriticite.add(new Criticite("Extrême","Cellule de crise activée"));
		
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
		Mesure mesure = new Mesure(1, "Mesure 1", "Description Mesure 1",vulnerabilite);
		assertEquals(mesure.getIdMesure(),1);
		assertEquals(mesure.getNomMesure(),"Mesure 1");
		assertEquals(mesure.getDescriptionMesure(),"Description Mesure 1");
		assertEquals(mesure.getVulnerabilite(),vulnerabilite);
	}
	
	@Test
	void testConstructeur2() {
		ArrayList <Criticite> listeCriticite = new ArrayList<>();
		
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		listeCriticite.add(new Criticite("Elevée","Deconnecter les serveurs du réseau"));
		listeCriticite.add(new Criticite("Extrême","Cellule de crise activée"));
		
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
		Mesure mesure = new Mesure("Mesure 2", "Description Mesure 2",vulnerabilite);
		assertEquals(mesure.getNomMesure(),"Mesure 2");
		assertEquals(mesure.getDescriptionMesure(),"Description Mesure 2");
		assertEquals(mesure.getVulnerabilite(),vulnerabilite);
	}
	
	@Test
	void testSetters() {
		ArrayList <Criticite> listeCriticite = new ArrayList<>();
		
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		listeCriticite.add(new Criticite("Elevée","Deconnecter les serveurs du réseau"));
		listeCriticite.add(new Criticite("Extrême","Cellule de crise activée"));
		
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
		Mesure mesure = new Mesure();
		
		mesure.setIdMesure(1);
		mesure.setNomMesure("Mesure 3");
		mesure.setDescriptionMesure("Description Mesure 3");
		mesure.setVulnerabilite(vulnerabilite);
		
		assertEquals(mesure.getIdMesure(),1);
		assertEquals(mesure.getNomMesure(),"Mesure 3");
		assertEquals(mesure.getDescriptionMesure(),"Description Mesure 3");
		assertEquals(mesure.getVulnerabilite(),vulnerabilite);
	}
	
	@Test
	void testListMesure() {
		Mesure mesure = new Mesure();
		ResultSet rs = mesure.listMesure();
		Assert.assertNull(rs);
	}

}
