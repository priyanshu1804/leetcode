class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int x=1;
        Queue<int[]> q=new PriorityQueue<>((a,b)->(b[1]!=a[1])?b[1]-a[1]:a[0]-b[0]);
        q.offer(new int[]{0,memory1});
        q.offer(new int[]{1,memory2});
        while(x<=q.peek()[1]){
            int[] item=q.poll();
            item[1]-=x;
            q.offer(item);
            x++;
        }
        if(q.peek()[0]==0){
            memory1=q.poll()[1];
            memory2=q.poll()[1];
        }
        else{
            memory2=q.poll()[1];
            memory1=q.poll()[1];
        }
        return new int[]{x,memory1,memory2};
    }
}