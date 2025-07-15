class Solution {
    public int minOperations(int n) {
        int ans=0;
        while(n>0){
            int x=(int)(Math.log(n)/Math.log(2));
            int small=n-(1<<x);
            int big=(1<<(x+1))-n;
            n=Math.min(small,big);
            ans++;
        }
        return ans;
    }
}