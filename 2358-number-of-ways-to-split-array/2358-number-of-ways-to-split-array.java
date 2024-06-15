class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] pre=new long[nums.length];
        long[] suff=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                pre[i]=nums[i];
            }else{
                pre[i]=pre[i-1]+nums[i];
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                suff[i]=nums[i];
            }else{
                suff[i]=suff[i+1]+nums[i];
            }
        }
        int count=0;
        for(int i=0;i<pre.length-1;i++){
            if(pre[i]>=suff[i+1]){
                count++;
            }
        }
        return count;
    }
}