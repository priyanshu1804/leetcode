class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] pre=new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]^nums[i];
        }
        int[] ans=new int[nums.length];
        int flag=(int)(Math.pow(2,maximumBit))-1;
        for(int i=nums.length-1;i>=0;i--){
            ans[nums.length-1-i]=pre[i]^flag;
        }
        return ans;
    }
}