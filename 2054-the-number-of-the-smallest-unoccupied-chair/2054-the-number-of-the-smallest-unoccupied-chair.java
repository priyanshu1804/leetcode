class Pair{
    int start;
    int leave;
    int chair;
    public Pair(int start,int leave,int chair){
        this.start=start;
        this.leave=leave;
        this.chair=chair;
    }
}
class Solution{
    public int smallestChair(int[][] times,int targetFriend){
        int targetStart=times[targetFriend][0];
        int targetLeave=times[targetFriend][1];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<times.length;i++){
            if(times[i][0]==targetStart&&times[i][1]==targetLeave){
                targetFriend=i;
                break;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.leave,b.leave));
        int[] chairs=new int[times.length];
        Arrays.fill(chairs,-1);
        for (int i=0;i<times.length;i++){
            int start=times[i][0];
            int leave=times[i][1];
            while(!pq.isEmpty()&&pq.peek().leave<=start){
                Pair p=pq.poll();
                chairs[p.chair]=-1;
            }
            int chair=0;
            while(chairs[chair]!=-1){
                chair++;
            }
            chairs[chair]=i;
            if(i==targetFriend){
                return chair;
            }
            pq.add(new Pair(start,leave,chair));
        }
        return -1;
    }
}
