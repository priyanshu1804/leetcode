class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);
        if(n>0){
            prime[0]=false;
        }
        if(n>1){
            prime[1]=false;
        }
        for(int i=2;i*i<n;i++){
            if(prime[i]){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }
        long sum=0;
        long sum1=0;
        for(int i=0;i<n;i++){
            if(prime[i]){
                sum+=nums[i];
            }else{
                sum1+=nums[i];
            }
        }
        return Math.abs(sum-sum1);
    }
}