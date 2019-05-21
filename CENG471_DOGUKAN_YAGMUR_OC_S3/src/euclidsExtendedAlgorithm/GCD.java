package euclidsExtendedAlgorithm;

import java.math.BigInteger;

public class GCD {
    public static BigInteger gcdExtended(BigInteger a, BigInteger b, BigInteger x, BigInteger y) 
    { 
        // Base Case 
        if (a.equals(new BigInteger("0"))) { 
            x = new BigInteger("0"); 
            y = new BigInteger("1"); 
            return b; 
        } 
  
        BigInteger x1 = new BigInteger("1");
        BigInteger y1 = new BigInteger("1");
        BigInteger gcd = gcdExtended(b.mod(a), a, x1, y1); 
  
        
        x = y1.subtract((b.divide(a)).multiply(x1)); 
        y = x1; 
  
        return gcd; 
    } 
  
    public static void main(String[] args) //TESTER
    { 
    	BigInteger x = new BigInteger("1");
    	BigInteger y = new BigInteger("1"); 
    	BigInteger a = new BigInteger("45");
    	BigInteger b = new BigInteger("10"); 
    	BigInteger g = gcdExtended(a, b, x, y); 
        System.out.print("gcd(" + a + ", " + b + ") = " + g); 
    } 
}
