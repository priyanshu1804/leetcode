class Solution {
    public int waysToMakeFair(int[] nums) {
        int oddsum=0;
        int evensum=0;
        int ans=0;
        int n=nums.length;
        int[] even=new int[n];
        int[] odd=new int[n];
        for(int i=0;i<n;i++){
            if(i%2==0){
                evensum+=nums[i];
            }else{
                oddsum+=nums[i];
            }
            even[i]=evensum;
            odd[i]=oddsum;
        }
        for(int i=0;i<n;i++){
            if(i==0){
                int nos=even[n-1]-nums[0];
                int nes=odd[n-1];
                if(nos==nes){
                    ans++;
                }
            }else{
                int nos=odd[i-1]+even[n-1]-even[i];
                int nes=even[i-1]+odd[n-1]-odd[i];
                if(nos==nes){
                    ans++;
                }
            }
        }
        return ans;
    }
}