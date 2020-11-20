import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;
import com.hackingnews.model.Mesure;
import com.mysql.jdbc.ResultSet;

class LogicielTest {

	@Test
	void testConstructeur() {
		Logiciel logiciel = new Logiciel();
		Assert.assertNotNull(logiciel);
	}
	
	@Test
	void testConstructeur1() {
		Logiciel logiciel = new Logiciel(1, "Eclipse", "IDE Java");
		assertEquals(logiciel.getIdLogiciel(),1);
		assertEquals(logiciel.getNom(),"Eclipse");
		assertEquals(logiciel.getDescription(),"IDE Java");
	}
	
	@Test
	void testConstructeur2() {
		Logiciel logiciel = new Logiciel("Word", "Traitement de texte");
		assertEquals(logiciel.getNom(),"Word");
		assertEquals(logiciel.getDescription(),"Traitement de texte");
	}
	
	@Test
	void testSetters() {
		Logiciel logiciel = new Logiciel();
		logiciel.setIdLogiciel(1);
		logiciel.setNom("Word");
		logiciel.setDescription("Traitement de texte");
	}
	
	@Test
	void testListLogiciel() {
		Logiciel logiciel = new Logiciel();
		ResultSet rs = logiciel.listLogiciel();
		
		Assert.assertNull(rs);
	}
}
