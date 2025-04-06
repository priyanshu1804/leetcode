class Solution {
    List<Integer> res;
    public void solve(int i,int prev,int[] nums,List<Integer> ans,int[] dp){
        if(i>=nums.length){
            if(ans.size()>res.size()){
                res.clear();
                res.addAll(ans);
            }
            return;
        }
        if(ans.size()>dp[i]&&(nums[i]%prev==0||prev%nums[i]==0)){
            dp[i]=ans.size();
            ans.add(nums[i]);
            solve(i+1,nums[i],nums,ans,dp);
            ans.remove(ans.size()-1);
        }
        solve(i+1,prev,nums,ans,dp);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        res=new ArrayList<>();
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        solve(0,1,nums,ans,dp);
        return res;
    }
}