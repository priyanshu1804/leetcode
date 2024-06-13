class Solution {
    public int gcd(int i,int j){
        while(i%j!=0){
            int rem=i%j;
            i=j;
            j=rem;
        }
        return j;
    }
    public long countPairs(int[] nums, int k) {
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            int gcd1=gcd(val,k);
            for(int gcd2:map.keySet()){
                if((long)gcd1*gcd2%k==0){
                    ans+=map.get(gcd2);
                }
            }
            map.put(gcd1,map.getOrDefault(gcd1,0)+1);
        }
        return ans;
    }
}