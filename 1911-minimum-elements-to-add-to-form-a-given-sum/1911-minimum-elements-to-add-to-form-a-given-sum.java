class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        sum=Math.abs(goal-sum);
        return (sum%limit==0)?(int)(sum/(long)limit):(int)(sum/(long)limit+1);
    }
}