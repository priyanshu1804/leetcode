class unionfind{
    int n;
    int[] par;
    unionfind(int n){
        this.n=n;
        this.par=new int[n];
        Arrays.fill(par,-1);
    }
    public int find(int node){
        while(par[node]>=0){
            node=par[node];
        }
        return node;
    }
    public void union(int node1,int node2){
        int par1=find(node1);
        int par2=find(node2);
        if(par1==par2){
            return;
        }
        par[par2]=par1;
    }
}
class Solution {
    public int solve(int[] source,int[] target,List<Integer> arr){
        HashMap<Integer,Integer> s=new HashMap<>();
        HashMap<Integer,Integer> t=new HashMap<>();
        for(int it:arr){
            s.put(source[it],s.getOrDefault(source[it],0)+1);
            t.put(target[it],t.getOrDefault(target[it],0)+1);
        }
        int ans=0;
        for(int it:s.keySet()){
            if(t.containsKey(it)){
                ans+=Math.min(s.get(it),t.get(it));
            }
        }
        return arr.size()-ans;
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        unionfind uf=new unionfind(n);
        for(int[] it:allowedSwaps){
            uf.union(it[0],it[1]);
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int par=uf.find(i);
            map.putIfAbsent(par,new ArrayList<>());
            map.get(par).add(i);
        }
        int ans=0;
        for(int it:map.keySet()){
            ans+=solve(source,target,map.get(it));
        }
        return ans;
    }
}