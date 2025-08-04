class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int solve(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int lcm=1;
            for(int j=i;j<n;j++){
                lcm=solve(lcm,nums[j]);
                if(lcm>k){
                    break;
                }
                ans+=(lcm==k)?1:0;
            }
        }
        return ans;
    }
}