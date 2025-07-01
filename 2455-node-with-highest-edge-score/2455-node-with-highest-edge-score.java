class Solution {
    public int edgeScore(int[] edges) {
        long[] ans=new long[edges.length];
        for(int i=0;i<edges.length;i++){
            ans[edges[i]]+=i;
        }
        long max=-1;
        int ans1=-1;
        for(int i=0;i<edges.length;i++){
            if(ans[i]>max){
                max=ans[i];
                ans1=i;
            }
        }
        return ans1;
    }
}