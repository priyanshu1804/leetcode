class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n=100005;
        long[] pre=new long[n];
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<segments.length;i++){
            int start=segments[i][0];
            int end=segments[i][1];
            int color=segments[i][2];
            set.add(start);
            set.add(end);
            pre[start]+=color;
            pre[end]-=color;
        }
        for(int i=1;i<n;i++){
            pre[i]+=pre[i-1];
        }
        List<List<Long>> ans=new ArrayList<>();
        long prev=set.first();
        set.remove((int)prev);
        for(int it:set){
            long curr=it;
            List<Long> ds=new ArrayList<>();
            ds.add(prev);
            ds.add(curr);
            ds.add(pre[(int)prev]);
            if(pre[(int)prev]!=0){
                ans.add(ds);
            }
            prev=curr;
        }
        return ans;
    }
}