class Solution {
    public int solve(int[] nums1,int[] nums2){
        int sum=0;
        for(int i=0;i<nums2.length;i++){
            sum+=nums2[i];
        }
        int max=sum;
        int sum1=0;
        for(int i=0;i<nums1.length;i++){
            sum1+=(nums1[i]-nums2[i]);
            sum1=sum1>0?sum1:0;
            max=Math.max(max,sum+sum1);
        }
        return max;
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1,nums2),solve(nums2,nums1));
    }
}