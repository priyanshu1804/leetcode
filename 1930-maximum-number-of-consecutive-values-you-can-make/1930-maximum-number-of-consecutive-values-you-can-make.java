class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans=1;
        for(int it:coins){
            if(ans>=it){
                ans+=it;
            }else{
                break;
            }
        }
        return ans;
    }
}