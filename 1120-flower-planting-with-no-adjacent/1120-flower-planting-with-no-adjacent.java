class Solution {
    public void solve(ArrayList<ArrayList<Integer>> adj,int[] color,int node){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            int c=color[curr];
            for(int it:adj.get(curr)){
                if(color[it]==-1||c==color[it]){
                    if(c==4){
                        color[it]=1;
                    }else{
                        color[it]=c+1;
                    }
                    q.add(it);
                }
            }
        }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<paths.length;i++){
            int u=paths[i][0];
            int v=paths[i][1];
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                solve(adj,color,i);
            }
        }
        return color;
    }
}