class Solution {
    public boolean canSortArray(int[] nums) {
        int count=Integer.bitCount(nums[0]);
        int prev=-1;
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            if(Integer.bitCount(nums[i])!=count){
                count=Integer.bitCount(nums[i]);
                prev=Math.max(curr,prev);
                curr=nums[i];
            }else{
                curr=Math.max(curr,nums[i]);
            }
            if(prev!=-1&&nums[i]<prev){
                return false;
            }
        }
        return true;
    }
}