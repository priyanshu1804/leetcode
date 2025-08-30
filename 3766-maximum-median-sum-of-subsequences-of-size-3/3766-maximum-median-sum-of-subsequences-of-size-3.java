class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        long ans=0;
        while(i<j){
            ans+=nums[j-1];
            i++;
            j-=2;
        }
        return ans;
    }
}