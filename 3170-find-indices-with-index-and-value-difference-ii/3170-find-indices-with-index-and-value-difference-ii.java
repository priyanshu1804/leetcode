class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if(indexDifference>=nums.length){
            return new int[]{-1,-1};
        }
        int minvalue=Integer.MAX_VALUE;
        int minindex = 0;
        int maxvalue=Integer.MIN_VALUE;
        int maxindex = 0;
        for(int i=nums.length-indexDifference-1,j=nums.length-1;i>=0;i--,j--){
            if(nums[j]<minvalue){
                minvalue=nums[j];
                minindex=j;
            }
            if(nums[j]>maxvalue){
                maxvalue=nums[j];
                maxindex=j;
            }
            if(Math.abs(nums[i]-minvalue)>=valueDifference){
                return new int[]{i,minindex};
            }
            if(Math.abs(nums[i]-maxvalue)>=valueDifference){
                return new int[]{i,maxindex};
            }
        }
        return new int[]{-1,-1};
    }
}