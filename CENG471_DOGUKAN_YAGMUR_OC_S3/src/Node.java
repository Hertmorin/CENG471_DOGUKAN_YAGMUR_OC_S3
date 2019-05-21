import java.math.BigInteger;
import java.util.List;

public class Node extends RSA {
	
	//private static final String IV = "AAACCCDDDYYUURRS";

	public BigInteger privateKey;
	public BigInteger publicKey;
	public BigInteger commonSecret;
	
	
	public BigInteger getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(BigInteger privateKey) {
		this.privateKey = privateKey;
	}
	public BigInteger getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}
	public BigInteger getCommonSecret() {
		return commonSecret;
	}
	public void setCommonSecret(BigInteger commonSecret) {
		this.commonSecret = commonSecret;
	}
	
	/*
	 * public String encrypt(String text) throws Exception { return
	 * super.encrypt(commonSecret.toString(), IV, text); }
	 * 
	 * public String decrypt(String text) throws Exception { return
	 * super.decrypt(commonSecret.toString(), IV, text); }
	 */
	
	Node(int N) {
		super(N);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public List<BigInteger> encryptPublicKey(String message) {
		return super.encryptPublicKey(message);
	}
	
	public List<BigInteger> encryptPrivateKey(String message) {
		return super.encryptPrivateKey(message);
	}
	
	public String decryptPublicKey(List<BigInteger> message) {
		return super.decryptPublicKey(message);
	}
	
	public String decryptPrivateKey(List<BigInteger> message) {
		return super.decryptPrivateKey(message);
	}

}