class Solution {
    public int solve(int[] arr,int idx,int flag,int[][] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        int ans=0;
        if(flag==0){
            if(arr[idx]>=arr[idx-1]){
                return 0;
            }
            ans=1+solve(arr,idx+1,1,dp);
        }else{
            if(arr[idx]<=arr[idx-1]){
                return 0;
            }
            ans=1+solve(arr,idx+1,0,dp);
        }
        return dp[idx][flag]=ans;
    }
    public int maxTurbulenceSize(int[] arr) {
        int[][] dp=new int[arr.length][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(ans,Math.max(1+solve(arr,i+1,1,dp),1+solve(arr,i+1,0,dp)));
        }
        return ans;
    }
}