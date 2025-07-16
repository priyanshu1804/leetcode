class Solution {
    public boolean solve(int i,int[] arr,Boolean[] dp,int n){
        if(i>=n||i<0||arr[i]==-1){
            return false;
        }
        if(arr[i]==0){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int val=arr[i];
        arr[i]=-1;
        return dp[i]=solve(i+val,arr,dp,n)||solve(i-val,arr,dp,n);
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Boolean[] dp=new Boolean[n+1];
        return solve(start,arr,dp,n);
    }
}