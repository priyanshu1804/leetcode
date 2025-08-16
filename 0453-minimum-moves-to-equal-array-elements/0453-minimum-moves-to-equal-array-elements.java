class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        long sum=0;
        for(int num:nums){
            sum+=num;
            min=Math.min(min,num);
        }
        return (int)(sum-(long)min*nums.length);
    }
}