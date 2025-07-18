class Solution {
    int mod=(int)1e9+7;
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int solve(int i,int one,int two,int[] nums,int[][][] dp){
        if(i>=nums.length){
            return (one!=0&&two!=0&&one==two)?1:0;
        }
        if(dp[i][one][two]!=-1){
            return dp[i][one][two];
        }
        int ans=0;
        ans=(ans+solve(i+1,(one==0)?nums[i]:gcd(one,nums[i]),two,nums,dp))%mod;
        ans=(ans+solve(i+1,one,(two==0)?nums[i]:gcd(two,nums[i]),nums,dp))%mod;
        ans=(ans+solve(i+1,one,two,nums,dp))%mod;
        return dp[i][one][two]=ans%mod;
    }
    public int subsequencePairCount(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int[][][] dp=new int[nums.length][max+1][max+1];
        for(int[][] it:dp){
            for(int[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        return solve(0,0,0,nums,dp);
    }
}