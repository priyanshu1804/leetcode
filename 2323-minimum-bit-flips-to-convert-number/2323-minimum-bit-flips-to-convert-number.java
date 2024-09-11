class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=0;
        while(start>0||goal>0){
            int a=(start&1);
            int b=(goal&1);
            if(a!=b){
                ans++;
            }
            start=start>0?start>>1:0;
            goal=goal>0?goal>>1:0;
        }
        return ans;
    }
}