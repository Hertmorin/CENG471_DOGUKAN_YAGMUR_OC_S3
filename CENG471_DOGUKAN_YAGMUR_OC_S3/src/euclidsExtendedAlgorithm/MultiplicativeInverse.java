package euclidsExtendedAlgorithm;

import java.math.BigInteger;

public class MultiplicativeInverse {
	
	public static BigInteger multiplicativeInverse(BigInteger bi1, BigInteger bi2) {
		
		return bi1.modInverse(bi2);
	}
	
}
