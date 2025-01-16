class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int one=0;
        int two=0;
        int n=nums1.length;
        int m=nums2.length;
        if(m%2!=0){
            for(int it:nums1){
                one^=it;
            }
        }
        if(n%2!=0){
            for(int it:nums2){
                two^=it;
            }
        }
        return one^two;
    }
}