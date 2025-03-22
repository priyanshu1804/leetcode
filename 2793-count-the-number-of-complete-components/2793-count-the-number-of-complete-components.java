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
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            ds.unionBySize(u,v);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            int parent=ds.findUpar(i);
            map.put(parent,map.getOrDefault(parent,0)+1);
            map1.put(parent,map1.getOrDefault(parent,0)+adj.get(i).size());
        }
        int count=0;
        for(int it:map.keySet()) {
            int size=map.get(it);
            int edge=map1.get(it)/2; 
            if(edge==(size*(size-1))/2){
                count++;
            }
        }
        return count;
    }
}