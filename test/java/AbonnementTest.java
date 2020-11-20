import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Abonnement;
import com.hackingnews.model.Abonnes;
import com.mysql.jdbc.ResultSet;


class AbonnementTest {
	
	@Test
	void testConstructeur() {
		Abonnement abonnement = new Abonnement();
		Assert.assertNotNull(abonnement);
	}
	
	@Test
	void testConstructeur1C() {
		Abonnes abonne = new Abonnes(1, "GOMES", "Julien", "julien.gomes.dias@gmail.com");
		Abonnement abonnement = new Abonnement(abonne, "PDF", "Week", 1);
		assertEquals(abonnement.getAbonne(),abonne);
		assertEquals(abonnement.getFrequence(),"Week");
		assertEquals(abonnement.getFormat(),"PDF");
		assertEquals(abonnement.getStatut(),1);
	}
	
	@Test
	void testSetters() {
		Abonnes abonne = new Abonnes(1, "GOMES", "Julien", "julien.gomes.dias@gmail.com");
		Abonnement abonnement = new Abonnement();
		abonnement.setAbonne(abonne);
		abonnement.setFrequence("Week");
		abonnement.setFormat("PDF");
		abonnement.setStatut(1);
		Assert.assertEquals(abonnement.getAbonne(),abonne);
		Assert.assertEquals(abonnement.getFrequence(),"Week");
		Assert.assertEquals(abonnement.getFormat(),"PDF");
		Assert.assertEquals(abonnement.getStatut(),1);

	}
	
	@Test
	void testListAbonnement() {
		Abonnement abonnement = new Abonnement();
		ResultSet rs = abonnement.listAbonnement();
		Assert.assertNotNull(rs);
	}
}
