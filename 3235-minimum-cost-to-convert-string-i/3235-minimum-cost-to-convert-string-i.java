class Solution {
    public long[] solve(int start,List<int[]>[] adj){
        PriorityQueue<Pair<Long,Integer>> pq=new PriorityQueue<>((a,b)->Long.compare(a.getKey(),b.getKey()));
        pq.add(new Pair<>(0L,start));
        long[] ans=new long[26];
        Arrays.fill(ans,-1L);
        while(!pq.isEmpty()){
            Pair<Long,Integer> curr=pq.poll();
            long cost=curr.getKey();
            int current=curr.getValue();
            if(ans[current]!=-1L&&ans[current]<cost){
                continue;
            }
            for(int[] it:adj[current]){
                int target=it[0];
                long cost1=it[1];
                long toatlcost=cost+cost1;
                if(ans[target]==-1L||toatlcost<ans[target]){
                    ans[target]=toatlcost;
                    pq.add(new Pair<>(toatlcost,target));
                }
            }
        }
        return ans;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<int[]>[] adj=new List[26];
        for(int i=0;i<26;i++){
            adj[i]=new ArrayList<>();
        }
        int length=original.length;
        for(int i=0;i<length;i++){
            adj[original[i]-'a'].add(new int[]{changed[i]-'a',cost[i]});
        }
        long[][] ans=new long[26][26];
        for(int i=0;i<26;i++){
            ans[i]=solve(i,adj);
        }
        long total=0;
        int n=source.length();
        for(int i=0;i<n;i++){
            if(source.charAt(i)!=target.charAt(i)){
                long cost1=ans[source.charAt(i)-'a'][target.charAt(i)-'a'];
                if(cost1==-1){
                    return -1;
                }
                total+=cost1;
            }
        }
        return total;
    }
}