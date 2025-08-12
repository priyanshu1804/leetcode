class Solution {
    public long findMaximumScore(List<Integer> nums){
        int n=nums.size();
        int prev=nums.get(0);
        int previ=0;
        long ans=0;
        for(int i=1;i<n-1;i++){
            if(nums.get(i)>prev){
                ans+=(long)(i-previ)*prev;
                prev=nums.get(i);
                previ=i;
            }
        }
        ans+=(long)((n-1)-previ)*prev;
        return ans;
    }
}