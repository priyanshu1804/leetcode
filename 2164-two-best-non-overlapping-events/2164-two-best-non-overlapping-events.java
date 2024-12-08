class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[] > pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int max=0;
        int ans=0;
        for(int[] it:events){
            while(!pq.isEmpty()&&pq.peek()[1]<it[0]){
                max=Math.max(max,pq.peek()[2]);
                pq.poll();
            }
            ans=Math.max(ans,max+it[2]);
            pq.add(it);
        }
        return ans;
    }
}