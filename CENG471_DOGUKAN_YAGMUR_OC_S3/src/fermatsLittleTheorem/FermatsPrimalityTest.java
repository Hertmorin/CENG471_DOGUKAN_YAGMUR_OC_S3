package fermatsLittleTheorem;

import java.math.BigInteger;

public class FermatsPrimalityTest {
	
	public static Boolean isPrime(BigInteger n) {
		
		return n.isProbablePrime(1);
		
	}

}
