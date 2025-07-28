class Solution {
    public int solve(int[] nums,int i,int curr,int target){
        if(i==nums.length){
            if(curr==target){
                return 1;
            }else{
                return 0;
            }
        }
        int notpick=solve(nums,i+1,curr,target);
        int pick=solve(nums,i+1,curr|nums[i],target);
        return pick+notpick;
    }
    public int countMaxOrSubsets(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=sum|nums[i];
        }
        return solve(nums,0,0,sum);
    }
}