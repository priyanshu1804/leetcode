class Solution {
    public int longestSubarray(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int count=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                count++;
            }else{
                count=0;
            }
            ans=Math.max(count,ans);
        }
        return ans;
    }
}