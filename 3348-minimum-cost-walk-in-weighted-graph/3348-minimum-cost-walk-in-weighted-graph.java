class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    } 
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulpu=findUpar(u);
        int ulpv=findUpar(v);
        if(ulpu==ulpv){
            return;
        }
        if(rank.get(ulpu)<rank.get(ulpv)){
            parent.set(ulpu,ulpv);
        }else if(rank.get(ulpv)<rank.get(ulpu)){
            parent.set(ulpv,ulpu);
        }else{
            parent.set(ulpv,ulpu);
            int ranku=rank.get(ulpu);
            rank.set(ulpu,ranku+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulpu=findUpar(u);
        int ulpv=findUpar(v);
        if(ulpu==ulpv){
            return;
        }
        if(size.get(ulpu)<size.get(ulpv)){
            parent.set(ulpu,ulpv);
            size.set(ulpv,size.get(ulpv)+size.get(ulpu));
        }else{
            parent.set(ulpv,ulpu);
            size.set(ulpu,size.get(ulpv)+size.get(ulpu));
        }
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds=new DisjointSet(n);
        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int[] it:edges){
            ds.unionBySize(it[0],it[1]);
        }
        for(int[] it:edges){
            int root=ds.findUpar(it[0]);
            cost[root]&=it[2]; 
        }
        int[] ans=new int[query.length];
        for(int i=0;i<query.length;i++){
            int start=query[i][0];
            int end=query[i][1];
            if(ds.findUpar(start)!=ds.findUpar(end)){
                ans[i]=-1;
            }else{
                ans[i]=cost[ds.findUpar(start)];
            }
        }
        return ans;
    }
}