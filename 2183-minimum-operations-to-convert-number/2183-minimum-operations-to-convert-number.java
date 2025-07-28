class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q=new LinkedList<>();
        int[] vis=new int[1001];
        int ans=0;
        q.offer(start);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                int temp=q.poll();
                if(temp==goal){
                    return ans;
                }
                if(temp<0||temp>1000||vis[temp]==1){
                    continue;
                }
                vis[temp]=1;
                for(int it:nums){
                    q.offer(temp+it);
                    q.offer(temp-it);
                    q.offer(temp^it);
                }
            }
            ans++;
        }
        return -1;
    }
}