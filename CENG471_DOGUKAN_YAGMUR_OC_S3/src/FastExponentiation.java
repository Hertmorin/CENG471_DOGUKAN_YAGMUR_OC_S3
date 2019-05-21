import java.math.BigInteger;

public class FastExponentiation {

	public static BigInteger expo(BigInteger a, BigInteger b) {
		BigInteger result;

		if (b.compareTo(new BigInteger("2")) == 0)
			return a.multiply(a);

		if (b.compareTo(new BigInteger("1")) == 0)
			return a;

		if (b.mod(new BigInteger("2")).compareTo(new BigInteger("1")) == 0) {
			return a.multiply(expo(a, b.subtract(new BigInteger("1"))));
		} else {
			result = expo(a, b.divide(new BigInteger("2")));
			return result.multiply(result);
		}
	}

	public static BigInteger fastExponentiation(BigInteger primitive, BigInteger privateKey, BigInteger prime) {

		return expo(primitive, privateKey).mod(prime);
	}

	public static void main(String[] args) {	//TESTER
		BigInteger rez = expo(new BigInteger("2"), new BigInteger("15546")); 
		System.out.print(rez);
	}

}
