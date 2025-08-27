class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        int[] indegree=new int[n];
        int seen=0;
        int[][] dp=new int[n][26];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                dp[i][colors.charAt(i)-'a']=1;
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            seen++;
            for(int it:adj.get(curr)){
                for(int i=0;i<26;i++){
                    dp[it][i]=Math.max(dp[it][i],dp[curr][i]+((i==colors.charAt(it)-'a')?1:0));
                }
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(seen!=n){
            return -1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}