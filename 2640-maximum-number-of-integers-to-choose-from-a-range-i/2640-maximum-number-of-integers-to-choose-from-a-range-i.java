class Solution {
    public int solve(int index,int sum,int n,int target,int[] dp,int[] arr){
        if(index>n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick=0;
        if(arr[index]==1&&sum+index<=target){
            pick=1+solve(index+1,sum+index,n,target,dp,arr);
        }
        int notPick=solve(index+1,sum,n,target,dp,arr);
        dp[index]=Math.max(pick,notPick);
        return dp[index];
    }
    public int maxCount(int[] banned,int n,int maxSum){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int[] arr=new int[n+1];
        Arrays.fill(arr,1);
        for(int it:banned){
            if(it<=n){
                arr[it]=0;
            }
        }
        return solve(1,0,n,maxSum,dp,arr);
    }
}
