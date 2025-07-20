class Solution {
    int mod=(int)1e9+7;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int it:nums){
            pq.add(it);
        }
        while(k-->0&&!pq.isEmpty()){
            int x=pq.remove();
            x+=1;
            pq.add(x);
        }
        long pro=1;
        while(!pq.isEmpty()){
            pro=(pro*pq.remove())%mod;
        }
        return (int)pro;
    }
}