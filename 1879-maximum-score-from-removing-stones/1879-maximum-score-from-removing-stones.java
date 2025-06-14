class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int ans=0;
        while(true){
            int x=pq.poll();
            int y=pq.poll();
            if(y==0){
                break; 
            }
            x--;
            y--;
            ans++;
            pq.add(x);
            pq.add(y);
        }
        return ans;
    }
}