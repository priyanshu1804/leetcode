class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]==1){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
        }
        int[] ans=new int[n-k+1];
        int j=0;
        for(int i=k-1;i<n;i++){
            if(dp[i]>=k){
                ans[j]=nums[i];
            }else{
                ans[j]=-1;
            }
            j++;
        }
        return ans;
    }
}