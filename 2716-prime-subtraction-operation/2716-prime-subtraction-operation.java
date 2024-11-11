class Solution {
    public boolean solve(int x){
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean primeSubOperation(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count;
            if(i==0){
                count=nums[0];
            }
            else{
                count=nums[i]-nums[i-1];
            }
            if(count<=0){
                return false;
            }
            int prime=0;
            for(int j=count-1;j>=2;j--){
                if(solve(j)){
                    prime=j;
                    break;
                }
            }
            nums[i]=nums[i]-prime;
        }
        return true;
    }
}