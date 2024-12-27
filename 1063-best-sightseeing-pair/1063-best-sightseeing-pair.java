class Solution {
    int ans=0;
    public int solve(int idx,int[] values){
        if(idx<0){
            return 0;
        }
        int val=values[idx];
        int prev=solve(idx-1,values);
        ans=Math.max(ans,prev+val-idx);
        return Math.max(prev,val+idx);
    }
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        solve(n-1,values);
        return ans;
    }
}