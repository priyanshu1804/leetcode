class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n=nums.length;
        int sum=0;
        int sum1=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int x=Math.abs(nums[i]-nums[i+1]);
            sum+=x;
            sum1=Math.max(sum1,Math.abs(nums[i+1]-nums[0])-x);
            sum1=Math.max(sum1,Math.abs(nums[i]-nums[n-1])-x);
            min=Math.min(min,Math.max(nums[i],nums[i+1]));
            max=Math.max(max,Math.min(nums[i],nums[i+1]));
        }
        return sum+Math.max(sum1,2*(max-min));
    }
}