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
    boolean isvalid(int nrow,int ncol,int n){
        return (nrow>=0&&nrow<n&&ncol>=0&&ncol<n);
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    continue;
                }
                int[] dr={-1,0,1,0};
                int[] dc={0,-1,0,1};
                for(int idx=0;idx<4;idx++){
                    int nrow=i+dr[idx];
                    int ncol=j+dc[idx];
                    if(isvalid(nrow,ncol,n)&&grid[nrow][ncol]==1){
                        int nodeno=i*n+j;
                        int adjnode=nrow*n+ncol;
                        ds.unionBySize(nodeno,adjnode);
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    continue;
                }
                int[] dr={-1,0,1,0};
                int[] dc={0,-1,0,1};
                HashSet<Integer> set=new HashSet<>();
                for(int idx=0;idx<4;idx++){
                    int nrow=i+dr[idx];
                    int ncol=j+dc[idx];
                    if(isvalid(nrow,ncol,n)&&grid[nrow][ncol]==1){
                        set.add(ds.findUPar(nrow*n+ncol));
                    }
                }
                int size=0;
                for(Integer parents:set){
                    size+=ds.size.get(parents);
                }
                max=Math.max(max,size+1);
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max,ds.size.get(ds.findUPar(i)));
        }
        return max;
    }
}