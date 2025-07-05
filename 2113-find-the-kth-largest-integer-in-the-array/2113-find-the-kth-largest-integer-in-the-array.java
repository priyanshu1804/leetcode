import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(String s:nums){
            pq.add(new BigInteger(s));
        }
        while(k!=1){
            pq.remove();
            k--;
        }
        return pq.remove()+"";
    }
}