class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=0;
        int sum=nums[0];
        int i=0;
        int j=0;
        while(j<nums.length){
            if(j+1<nums.length&&nums[j+1]>nums[j]){
                sum+=nums[j+1];
            }
            else if(j+1>=nums.length){
                max=Math.max(max,sum);
                break;
            }
            else{
                max=Math.max(max,sum);
                i=j+1;
                sum=nums[i];
            }
            j++;
        }
        return max;
    }
}