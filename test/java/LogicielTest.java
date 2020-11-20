import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hackingnews.model.Criticite;
import com.hackingnews.model.Logiciel;

class LogicielTest {

	@Test
	void testLogiciel1() {
		Logiciel logiciel = new Logiciel(1, "Eclipse", "IDE Java");
		assertEquals(logiciel.getIdLogiciel(),1);
		assertEquals(logiciel.getNom(),"Eclipse");
		assertEquals(logiciel.getDescription(),"IDE Java");
	}
	
	@Test
	void testLogiciel2() {
		Logiciel logiciel = new Logiciel("Word", "Traitement de texte");
		assertEquals(logiciel.getNom(),"Word");
		assertEquals(logiciel.getDescription(),"Traitement de texte");
	}

}
