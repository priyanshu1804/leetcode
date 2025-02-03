class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1;
        int curr=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                curr++;
            }else{
                max=Math.max(max,curr);
                curr=1;
            }
        }
        max=Math.max(max,curr);
        int max1=1;
        int curr1=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                curr1++;
            }else{
                max1=Math.max(max1,curr1);
                curr1=1;
            }
        }
        max1=Math.max(max1,curr1);
        return Math.max(max1,max);
    }
}