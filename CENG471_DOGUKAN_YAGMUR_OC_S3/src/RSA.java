import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RSA {
	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigInteger privateKey;
	private BigInteger publicKey;
	private BigInteger modulus;

	// generate an N-bit (roughly) public and private key
	RSA(int N) {
		BigInteger p = BigInteger.probablePrime(N / 2, random);
		BigInteger q = BigInteger.probablePrime(N / 2, random);
		BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

		modulus = p.multiply(q);
		publicKey = BigInteger.probablePrime(N / 2, random); // common value in practice = 2^16 + 1
		privateKey = publicKey.modInverse(phi);
		// privateKey = MultiplicativeInverse.multiplicativeInverse(publicKey, phi); //My functions are worst in terms of runtime.
	}

	List<BigInteger> encryptPublicKey(String message) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			if ((i + 1) * 100 < message.length()) {
				list.add(message.substring(i * 100, (i + 1) * 100));
				i++;
			}
			else {
				list.add(message.substring(i * 100));
				break;
			}
		}
		
		List<BigInteger> list2 = new ArrayList<BigInteger>();
		for (i = 0; i < list.size(); i++) {
			list2.add(new BigInteger(list.get(i).getBytes()).modPow(publicKey, modulus));
		}
		return list2;
		// return FastExponentiation.fastExponentiation(new BigInteger(bytes), publicKey, modulus); //My functions are worst in terms of runtime.
	}
	
	List<BigInteger> encryptPrivateKey(String message) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			if ((i + 1) * 100 < message.length()) {
				list.add(message.substring(i * 100, (i + 1) * 100));
				i++;
			}
			else {
				list.add(message.substring(i * 100));
				break;
			}
		}
		
		List<BigInteger> list2 = new ArrayList<BigInteger>();
		for (i = 0; i < list.size(); i++) {
			list2.add(new BigInteger(list.get(i).getBytes()).modPow(privateKey, modulus));
		}
		return list2;
		// return FastExponentiation.fastExponentiation(new BigInteger(bytes), publicKey, modulus); //My functions are worst in terms of runtime.
	}
	
	String decryptPublicKey(List<BigInteger> encrypted) {
		String result = "";
		for (int i = 0; i < encrypted.size(); i++) {
			result += new String(encrypted.get(i).modPow(publicKey, modulus).toByteArray());
		}
		return result;
		// return new String(FastExponentiation.fastExponentiation(encrypted, privateKey, modulus).toByteArray()); //My functions are worst in terms of runtime.
	}

	String decryptPrivateKey(List<BigInteger> encrypted) {
		String result = "";
		for (int i = 0; i < encrypted.size(); i++) {
			result += new String(encrypted.get(i).modPow(privateKey, modulus).toByteArray());
		}
		return result;
		// return new String(FastExponentiation.fastExponentiation(encrypted, privateKey, modulus).toByteArray()); //My functions are worst in terms of runtime.
	}

	public String toString() {
		String s = "";
		s += "public  = " + publicKey + "\n";
		s += "private = " + privateKey + "\n";
		s += "modulus = " + modulus;
		return s;
	}

}