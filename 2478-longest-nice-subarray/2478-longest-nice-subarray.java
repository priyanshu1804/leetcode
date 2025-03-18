class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        int n=nums.length;
        int max=0;
        while(j<n){
            while((ans&nums[j])!=0){
                ans-=nums[i];
                i++;
            }
            ans+=nums[j];
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}