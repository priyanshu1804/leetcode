class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] freq=new int[32];
        long ans=0;
        long curr=0;
        long mod=1000000007;
        for(int it:nums){
            for(int i=0;i<32;i++){
                if((it&(1<<i))!=0){
                    freq[i]++;
                }
            }
        }
        for(int i=0;i<k;i++){
            curr=0;
            for(int j=0;j<32;j++){
                if(freq[j]>0){
                    freq[j]--;
                    curr+=1<<j;
                }
            }
            ans=(ans+curr*curr%mod)%mod;
        }
        return (int)ans;
    }
}