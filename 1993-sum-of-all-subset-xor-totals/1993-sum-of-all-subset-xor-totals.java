class Solution {
    public int solve(int idx,int sum,int[] nums){
        if(idx==nums.length){
            return sum;
        }
        int notpick=solve(idx+1,sum,nums);
        int pick=solve(idx+1,sum^nums[idx],nums);
        return notpick+pick;
    }
    public int subsetXORSum(int[] nums) {
        return solve(0,0,nums);
    }
}