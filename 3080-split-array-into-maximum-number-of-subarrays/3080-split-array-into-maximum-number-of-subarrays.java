class Solution {
    public int maxSubarrays(int[] nums) {
        int i=0;
        int ans=0;
        int and=Integer.MAX_VALUE;
        while(i<nums.length){
            and&=nums[i];
            if(and==0){
                ans++;
                and=Integer.MAX_VALUE;
            }
            i++;
        }
        if(ans>0){
            return ans;
        }
        return 1;
    }
}