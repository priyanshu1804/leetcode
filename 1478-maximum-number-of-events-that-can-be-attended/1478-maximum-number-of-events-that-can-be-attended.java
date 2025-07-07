class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int day=1;
        int i=0;
        int ans=0;
        while(i<n||!pq.isEmpty()){
            while(i<n&&events[i][0]==day){
                pq.add(events[i++][1]);
            }
            while(!pq.isEmpty()&&pq.peek()<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
            day++;
        }
        return ans;
    }
}