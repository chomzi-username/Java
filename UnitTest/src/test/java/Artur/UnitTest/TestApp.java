package Artur.UnitTest;

import Artur.UnitTest.App;
//import junit.framework.Test;
//import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


@SuppressWarnings("deprecation")
public class TestApp {
	
	private int a;
	private int b;
	
	@Test
	public void testDodawanie(){
		a = 5;
		b = 5;
		assertEquals(a, b);
	}

}
