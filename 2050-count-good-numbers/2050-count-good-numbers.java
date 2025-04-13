import java.math.BigInteger;
class Solution{
    int mod=1000000007;
    public int countGoodNumbers(long n){
        long odd=(n)/2;
        long even=(n+1)/2;
        BigInteger modVal=BigInteger.valueOf(mod);
        BigInteger pow5=BigInteger.valueOf(5).modPow(BigInteger.valueOf(even),modVal);
        BigInteger pow4=BigInteger.valueOf(4).modPow(BigInteger.valueOf(odd),modVal);
        BigInteger result=pow5.multiply(pow4).mod(modVal);
        return result.intValue();
    }
}
