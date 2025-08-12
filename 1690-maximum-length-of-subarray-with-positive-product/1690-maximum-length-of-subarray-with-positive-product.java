class Solution {
    public int getMaxLen(int[] nums) {
        int len=0;
        int count=0;
        int neg=0;
        int n=nums.length;
        for(int it:nums){
            if(it==0){
                neg=0;
                count=0;
                continue;
            }
            count++;
            if(it<0){
                neg++;
            }
            if(neg%2==0){
                len=Math.max(len,count);
            }
        }
        count=0;
        neg=0;
        for(int i=n-1;i>=0;i--){
            int it=nums[i];
            if(it==0){
                neg=0;
                count=0;
                continue;
            }
            count++;
            if(it<0){
                neg++;
            }
            if(neg%2==0){
                len=Math.max(len,count);
            }
        }
        return len;
    }
}