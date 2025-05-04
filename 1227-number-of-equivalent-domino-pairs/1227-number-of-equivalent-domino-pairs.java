class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq=new int[100];
        int ans=0;
        for(int[] it:dominoes){
            int val=it[0]<it[1]?it[0]*10+it[1]:it[1]*10+it[0];
            ans+=freq[val];
            freq[val]++;
        }
        return ans;
    }
}