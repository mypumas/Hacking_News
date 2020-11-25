import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hackingnews.model.Abonnes;
import com.mysql.jdbc.ResultSet;


class AbonnesTest {
	
	@Test
	void testConstructeur() {
		Abonnes abonne = new Abonnes();
		Assert.assertNotNull(abonne);
	}
	
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
	
	@Test
	void testSetters() {
		Abonnes abonne = new Abonnes();
		abonne.setIdAbonne(1);
		abonne.setNom("GOMES");
		abonne.setPrenom("Julien");
		abonne.setEmail("julien.gomes.dias@gmail.com");
		abonne.setLogin("julien");
		abonne.setPassword("thedoors");
		Assert.assertEquals(abonne.getIdAbonne(),1);
		Assert.assertEquals(abonne.getNom(),"GOMES");
		Assert.assertEquals(abonne.getPrenom(),"Julien");
		Assert.assertEquals(abonne.getEmail(),"julien.gomes.dias@gmail.com");
		Assert.assertEquals(abonne.getLogin(),"julien");
		Assert.assertEquals(abonne.getPassword(),"thedoors");
		
	}
	
	@Test
	void testListAbonnes() {
		Abonnes abonne = new Abonnes();
		ResultSet rs = abonne.listAbonnes();
		Assert.assertNotNull(rs);
	}
	
	@Test
	void testCreate() {
		//Abonnes abonne = new Abonnes("Gomes", "Julien", "julien.gomes@cimpa.com","","");
		
	}
}
