import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Abonnes;
import com.hackingnews.model.Criticite;
import com.mysql.jdbc.ResultSet;


class CriticiteTest {
	
	@Test
	void testConstructeur() {
		Criticite criticite = new Criticite();
		Assert.assertNotNull(criticite);
	}
	
	@Test
	void testConstructeur1() {
		Criticite criticite = new Criticite(1, "Faible", "Criticite de faible niveau");
		assertEquals(criticite.getIdCriticite(),1);
		assertEquals(criticite.getNiveau(),"Faible");
		assertEquals(criticite.getDescription(),"Criticite de faible niveau");
	}
	
	@Test
	void testConstructeur2() {
		Criticite criticite = new Criticite("Faible", "Criticite de faible niveau");
		assertEquals(criticite.getNiveau(),"Faible");
		assertEquals(criticite.getDescription(),"Criticite de faible niveau");
	}
	
	@Test
	void testSetters() {
		Criticite criticite = new Criticite();
		criticite.setIdCriticite(1);
		criticite.setNiveau("Faible");
		criticite.setDescription("Criticite de faible niveau");
		Assert.assertEquals(criticite.getIdCriticite(),1);
		Assert.assertEquals(criticite.getNiveau(),"Faible");
		Assert.assertEquals(criticite.getDescription(),"Criticite de faible niveau");
	}
	
	@Test
	void testListCriticite() {
		Criticite criticite = new Criticite();
		ResultSet rs = criticite.listCriticite();
		Assert.assertNull(rs);
	}

}
