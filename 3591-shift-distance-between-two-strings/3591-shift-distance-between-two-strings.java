class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int start=s.charAt(i)-'a';
            int end=t.charAt(i)-'a';
            if(start==end){
                continue;
            }
            int k=(end-start+26)%26;
            long cost=0;
            for(int j=0;j<k;j++){
                cost+=nextCost[(start+j)%26];
            }
            int x=(start-end+26)%26;
            long cost1=0;
            for(int j=0;j<x;j++){
                cost1+=previousCost[(start-j+26)%26];
            }
            ans+=Math.min(cost,cost1);
        }
        return ans;
    }
}