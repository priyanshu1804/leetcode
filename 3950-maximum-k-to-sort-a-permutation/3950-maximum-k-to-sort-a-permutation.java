class Solution {
    public int sortPermutation(int[] nums) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                ans&=nums[i];
            }
        }
        return (ans!=-1)?ans:0;
    }
}