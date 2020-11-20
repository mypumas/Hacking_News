import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hackingnews.model.Abonnes;

class AbonnesTest {

	@Test
	void testConstructeur1() {
		
		Abonnes abonne = new Abonnes(1, "GOMES", "Julien", "julien.gomes.dias@gmail.com");
		assertEquals(abonne.getIdAbonne(),1);
		assertEquals(abonne.getNom(),"GOMES");
		assertEquals(abonne.getPrenom(),"Julien");
		assertEquals(abonne.getEmail(),"julien.gomes.dias@gmail.com");	
	}
	
	@Test
	void testConstructeur2() {
		
		Abonnes abonne = new Abonnes("mypumas", "thedoors");
		assertEquals(abonne.getLogin(),"mypumas");
		assertEquals(abonne.getPassword(),"thedoors");	
	}
	
	@Test
	void testConstructeur3() {
		
		Abonnes abonne = new Abonnes("GOMES", "Julien", "julien.gomes.dias@gmail.com","mypumas", "thedoors");
		assertEquals(abonne.getNom(),"GOMES");
		assertEquals(abonne.getPrenom(),"Julien");
		assertEquals(abonne.getEmail(),"julien.gomes.dias@gmail.com");
		assertEquals(abonne.getLogin(),"mypumas");
		assertEquals(abonne.getPassword(),"thedoors");
	}
}
