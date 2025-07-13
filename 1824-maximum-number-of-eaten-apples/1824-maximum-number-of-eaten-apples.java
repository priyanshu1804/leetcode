class pair{
    int count;
    int range;
    public pair(int count,int range){
        this.count=count;
        this.range=range;
    }
}
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.range-b.range);
        int ans=0;
        for(int i=0;i<apples.length||!pq.isEmpty();i++){
            if(i<apples.length&&apples[i]!=0){
                pq.add(new pair(apples[i],i+days[i]));
            }
            while(!pq.isEmpty()&&pq.peek().range<=i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pair p=pq.poll();
                p.count-=1;
                if(p.count>0){
                    pq.add(p);
                }
                ans++;
            }
        }
        return ans;
    }
}