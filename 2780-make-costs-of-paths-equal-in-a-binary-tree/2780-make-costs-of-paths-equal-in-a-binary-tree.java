class Solution {
    int ans=0;
    public int dfs(int i,int n,int[] cost,int sum){
        if(i>n){
            return sum;
        }
        int left=dfs(2*i,n,cost,cost[i-1]+sum);
        int right=dfs(2*i+1,n,cost,cost[i-1]+sum);
        ans+=Math.abs(left-right);
        return Math.max(left,right);
    }
    public int minIncrements(int n, int[] cost) {
        dfs(1,n,cost,0);
        return ans;
    }
}