class DisjointSet {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n) {
        for (int i=0;i<=n;i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node) {
        if (node==parent.get(node)) {
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v) {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if (ulp_u==ulp_v) return;
        if (size.get(ulp_u)<size.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        } else {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int rowmax=0;
        int colmax=0;
        for(int i=0;i<n;i++){
            rowmax=Math.max(rowmax,stones[i][0]);
            colmax=Math.max(colmax,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(rowmax+colmax+1);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int noderow=stones[i][0];
            int nodecol=stones[i][1]+rowmax+1;
            ds.unionBySize(noderow,nodecol);
            map.put(noderow,1);
            map.put(nodecol,1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()){
                count++;
            }
        }
        return n-count;
    }
}