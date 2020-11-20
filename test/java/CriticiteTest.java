import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;

class CriticiteTest {

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

}
