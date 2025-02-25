class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd=0;
        int even=1;
        int curr=0;   
        int ans=0;     
        for(int it:arr){
            curr+=it;
            if(curr%2==1){
                ans=(ans+even)%1000000007;
                odd++;
            }else{
                ans=(ans+odd)%1000000007;
                even++;
            }
        }
        return ans;
    }
}