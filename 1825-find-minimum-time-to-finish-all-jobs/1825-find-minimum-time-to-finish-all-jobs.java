class Solution {
    public int ans=Integer.MAX_VALUE;
    public void solve(int i,int[] jobs,int[] dp,int k){
        if(i<0){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max=Math.max(max,dp[j]);
            }
            ans=Math.min(ans,max);
            return;
        }
        for(int j=0;j<k;j++){
            if(j>0&&dp[j]==dp[j-1]){
                continue;
            }
            if(dp[j]+jobs[i]>ans){
                continue;
            }
            dp[j]+=jobs[i];
            solve(i-1,jobs,dp,k);
            dp[j]-=jobs[i];
        }
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] dp=new int[k];
        solve(jobs.length-1,jobs,dp,k);
        return ans;
    }
}