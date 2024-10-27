class Solution {
    public long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    public long maxScore(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return (long)nums[0]*nums[0];
        }
        long[] pregcd=new long[nums.length];
        long[] suffgcd=new long[nums.length];
        long[] prelcm=new long[nums.length];
        long[] sufflcm=new long[nums.length];
        pregcd[0]=nums[0];
        suffgcd[n-1]=nums[n-1];
        prelcm[0]=nums[0];
        sufflcm[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pregcd[i]=gcd(pregcd[i-1],nums[i]);
            prelcm[i]=lcm(prelcm[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suffgcd[i]=gcd(suffgcd[i+1],nums[i]);
            sufflcm[i]=lcm(sufflcm[i+1],nums[i]);
        }
        long max=pregcd[n-1]*prelcm[n-1];
        for(int i=0;i<n;i++){
            long curr;
            if(i==0){
                curr=suffgcd[1]*sufflcm[1];
                max=Math.max(max,curr);
                continue;
            }
            if(i==n-1){
                curr=pregcd[n-2]*prelcm[n-2];
                max=Math.max(max,curr);
                continue;
            }
            long gcdi=gcd(pregcd[i-1],suffgcd[i+1]);
            long lcmi=lcm(prelcm[i-1],sufflcm[i+1]);
            curr=gcdi*lcmi;
            max=Math.max(max,curr);
        }
        return max;
    }
}