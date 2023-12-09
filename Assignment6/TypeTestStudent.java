import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTestStudent {
	
	Type type1, type2, type3;

	@BeforeEach
	void setUp() throws Exception {
		type1 = Type.COFFEE;
		type2 = Type.ALCOHOL;
		type3 = Type.SMOOTHIE;
		
	}

	@AfterEach
	void tearDown() throws Exception {
		type1 = null;
		type2 = null;
		type3 = null;
	}

	@Test
	void test() {
		assertEquals(3, Type.values().length);
		assertEquals(Type.COFFEE, type1);
		assertFalse(Type.COFFEE.equals(type2));
		assertFalse(Type.COFFEE.equals(type3));
	}

}
