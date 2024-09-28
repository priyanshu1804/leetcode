class Solution {
    public int solve(int n){
        int ans=0;
        while(n>0){
            int x=n%10;
            ans+=x;
            n=n/10;
        }
        return ans;
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int x=solve(nums[i]);
            min=Math.min(min,x);
        }
        return min;
    }
}