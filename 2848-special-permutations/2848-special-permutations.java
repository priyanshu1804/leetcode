class Solution {
    int mod=(int)1e9+7;
    public long solve(int[] nums,int idx,int mask,int prev,Long[][] dp){
        if(idx>=nums.length){
            return 1;
        }
        if(dp[mask][prev+1]!=null){
            return dp[mask][prev+1];
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if((mask&(1<<i))!=0){
                continue;
            }
            if(prev==-1||nums[i]%nums[prev]==0||nums[prev]%nums[i]==0){
                ans+=solve(nums,idx+1,mask|(1<<i),i,dp);
                ans%=mod;
            }
        }
        return dp[mask][prev+1]=ans;
    }
    public int specialPerm(int[] nums) {
        int n=nums.length;
        int mask=(1<<n);
        Long[][] dp=new Long[mask][n+1];
        return (int)(solve(nums,0,0,-1,dp)%mod);
    }
}