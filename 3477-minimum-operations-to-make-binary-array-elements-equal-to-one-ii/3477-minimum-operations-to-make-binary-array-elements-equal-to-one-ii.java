class Solution {
    public int minOperations(int[] nums) {
        int sum=0;
        for(int it:nums){
            if(it==1){
                if(sum%2!=0){
                    sum++;
                }
            }else{
                if(sum%2==0){
                    sum++;
                }
            }
        }
        return sum;
    }
}