class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int it:piles){
            pq.add(it);
        }   
        while(k-->0){
            int x=pq.remove();
            x=(x+1)/2;
            pq.add(x);
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.remove();
        }
        return sum;
    }
}