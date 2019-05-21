import java.math.BigInteger;

import fermatsLittleTheorem.FermatsPrimalityTest;

public class DHKeyExchange {
	
	public static BigInteger generateKeys(Node nodeSender, Node nodeReceiver, BigInteger prime, BigInteger primitive, BigInteger senderPrivateKey, BigInteger receiverPrivateKey) {
		
		if(FermatsPrimalityTest.isPrime(prime)) {
			
			nodeSender.setPrivateKey(senderPrivateKey);
			nodeSender.setPublicKey(FastExponentiation.fastExponentiation(primitive, senderPrivateKey, prime));
			nodeReceiver.setPrivateKey(receiverPrivateKey);
			nodeReceiver.setPublicKey(FastExponentiation.fastExponentiation(primitive, receiverPrivateKey, prime));
			
			// public keys exchanged, now common secret keys are calculating
			BigInteger senderCommonSecret = FastExponentiation.fastExponentiation(nodeReceiver.getPublicKey(), senderPrivateKey, prime);
			BigInteger receiverCommonSecret = FastExponentiation.fastExponentiation(nodeSender.getPublicKey(), receiverPrivateKey, prime);
			
			if(senderCommonSecret.equals(receiverCommonSecret)) {
				nodeSender.setCommonSecret(senderCommonSecret);
				nodeReceiver.setCommonSecret(receiverCommonSecret);
				return BigInteger.ONE;
			}
				
		}
		return BigInteger.ZERO;
	}
	
}
