class Solution {
    public int racecar(int target) {
        Queue<long[]> q=new LinkedList<>();
        q.add(new long[]{0,1});
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                long[] curr=q.poll();
                if((int) curr[0]==target){
                    return ans;
                }
                long[] a=new long[]{curr[0]+curr[1],curr[1]*2};
                long[] r=new long[]{curr[0],curr[1]>0?-1:1};
                if(curr[0]+curr[1]<2*target){
                    q.add(a);
                }
                if((curr[1]>0&&curr[0]+curr[1]>target)||(curr[1]<0&&curr[0]+curr[1]<target)){
                    q.add(r);
                }
            }
            ans++;
        }
        return -1;
    }
}