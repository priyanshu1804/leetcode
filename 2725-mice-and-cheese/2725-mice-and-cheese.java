class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int x=0;
        int len=reward1.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<len;i++){
            pq.offer(new int[]{reward1[i]-reward2[i],reward1[i],reward2[i]});
        }
        while(!pq.isEmpty()&&k-->0){
            x+=pq.poll()[1];
        }
        while(!pq.isEmpty()){
            x+=pq.poll()[2];
        }
        return x;
    }
}
