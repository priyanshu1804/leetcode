class Solution {
    public int solve(int[] nums,int bound){
        int count=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j++]<=bound){
                count+=j-i;
            }
            else{
                i=j;
            }
        }
        return count;
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return solve(nums,right)-solve(nums,left-1);
    }
}