class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        double min=Double.MAX_VALUE;
        while(i<j){
            double ans=(double)(nums[i]+nums[j])/2;
            if(ans<min){
                min=ans;
            }
            i++;
            j--;
        }
        return min;
    }
}