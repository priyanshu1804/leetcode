class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if((sum-target)%2==1){
            return 0;
        }
        if(sum<target){
            return 0;
        }
        int s1=(sum-target)/2;
        int[][] dp=new int[nums.length][s1+1];
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(nums[0]!=0&&nums[0]<=s1){
            dp[0][nums[0]]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int k=0;k<=s1;k++){
                int notpick=dp[i-1][k];
                int pick=0;
                if(nums[i]<=k){
                    pick=dp[i-1][k-nums[i]];
                }
                dp[i][k]=pick+notpick;
            }
        }
        return dp[nums.length-1][s1];
    }
}