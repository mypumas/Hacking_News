import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;
import com.hackingnews.model.Vulnerabilite;
import com.hackingnews.model.VulnerabiliteLogiciel;
import com.mysql.jdbc.ResultSet;

class VulnerabiliteLogicielTest {

	@Test
	void testConstructeur() {
		VulnerabiliteLogiciel vl = new VulnerabiliteLogiciel();
		Assert.assertNotNull(vl);
	}
	
	@Test
	void testConstructeur1() {
		ArrayList <Criticite> listeCriticite = new ArrayList<>();	
		listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
		listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
		Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
		Logiciel logiciel = new Logiciel("Word", "Traitement de texte");
		
		VulnerabiliteLogiciel vl = new VulnerabiliteLogiciel(vulnerabilite,logiciel,"23122012");
		
		assertEquals(vl.getVulnerabilite(),vulnerabilite);
		assertEquals(vl.getLogiciel(),logiciel);
		assertEquals(vl.getDate(),"23122012");
	}	
	
	@Test
	void testSetters() {
			
			ArrayList <Criticite> listeCriticite = new ArrayList<>();	
			listeCriticite.add(new Criticite("Faible","Peu de risque de propagation"));
			listeCriticite.add(new Criticite("Modérée","Faire vérifier le logiciel"));
			Vulnerabilite vulnerabilite = new Vulnerabilite("CryptoLocker","Description CryptoLocker.",listeCriticite.get(1));
			Logiciel logiciel = new Logiciel("Word", "Traitement de texte");
			
			VulnerabiliteLogiciel vl = new VulnerabiliteLogiciel();
			
			vl.setVulnerabilite(vulnerabilite);
			vl.setLogiciel(logiciel);
			vl.setDate("23122012");
			
			assertEquals(vl.getVulnerabilite(),vulnerabilite);
			assertEquals(vl.getLogiciel(),logiciel);
			assertEquals(vl.getDate(),"23122012");;
	}
	
	@Test
	void testListVulnerabiliteLogiciel() {
		VulnerabiliteLogiciel vl = new VulnerabiliteLogiciel();
		ResultSet rs = vl.listVulnerabiliteLogiciel();
		Assert.assertNotNull(rs);
	}

}
