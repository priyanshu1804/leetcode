class Solution {
    public int sumOfBeauties(int[] nums) {
        int ans=0;
        int[] suff=new int[nums.length];
        suff[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suff[i]=Math.min(suff[i+1],nums[i]);
        }
        int pre=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(pre<nums[i]&&nums[i]<suff[i+1]){
                ans+=2;
            }else if(nums[i-1]<nums[i]&&nums[i]<nums[i+1]){
                ans++;
            }
            pre=Math.max(pre,nums[i]);
        }
        return ans;
    }
}