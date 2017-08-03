import junit.framework.*;

public class TestGenPrimes extends TestCase {
	public static void main(String args[]) {
		junit.swingui.TestRunner.main(new String[] {"TestGenPrimes"});
	}

	public TestGenPrimes(final String name) {
		super(name);
	}

	public void testPrimes() {
		int[] nullArray = PrimeGen.generatePrimeNumbers(0);
		assertEquals(nullArray.length, 0);
		int[] minArray = PrimeGen.generatePrimeNumbers(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);
		int[] threeArray = PrimeGen.generatePrimeNumbers(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);
		int[] hundredArray = PrimeGen.generatePrimeNumbers(100);
		assertEquals(hundredArray.length, 25);
		assertEquals(hundredArray[24], 97);
	}

	public void testExhaustive() {
		for(int i=2; i<500; i++) {
			verifyPrimeList(PrimeGen.generatePrimeNumbers(i));
		}
	}

	public void verifyPrimeList(final int[] list) {
		for(int i=0; i<list.length; i++) {
			verifyPrime(list[i]);
		}
	}

	public void verifyPrime(final int n) {
		for(int j=2; j<n; j++) {
			assert(n % j != 0);
		}
	}
}