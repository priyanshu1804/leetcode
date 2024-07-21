class Solution {
    public int[] solve(int[][] arr,int n){
        int[] indegree=new int[n+1];
        List<Integer>[] graph=new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:arr){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[i++]=node;
            for(int it:graph[node]){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(i!=n){
            return new int[0];
        }
        return ans;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row=solve(rowConditions,k);
        int[] col=solve(colConditions,k);
        if(row.length==0||col.length==0){
            return new int[0][0];
        }
        int[][] ans=new int[k][k];
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                if(row[i]==col[j]){
                    ans[i][j]=row[i];
                }
            }
        }
        return ans;
    }
}