package euclidsExtendedAlgorithm;

import java.math.BigInteger;

public class RelativelyPrimeCondition {
	
	static Boolean isRelativelyPrime(BigInteger n, BigInteger k) {

		if (n.gcd(k).equals(new BigInteger("1"))) {
			return true;
		}

		return false;
	}
	
}
