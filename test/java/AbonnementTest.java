import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hackingnews.model.Abonnement;
import com.hackingnews.model.Abonnes;

class AbonnementTest {

	@Test
	void test() {
		Abonnes abonne = new Abonnes(1, "GOMES", "Julien", "julien.gomes.dias@gmail.com");
		Abonnement abonnement = new Abonnement(abonne, "PDF", "Week", 1);
		assertEquals(abonnement.getAbonne(),abonne);
		assertEquals(abonnement.getFrequence(),"Week");
		assertEquals(abonnement.getFormat(),"PDF");
		assertEquals(abonnement.getStatut(),1);
	}

}
