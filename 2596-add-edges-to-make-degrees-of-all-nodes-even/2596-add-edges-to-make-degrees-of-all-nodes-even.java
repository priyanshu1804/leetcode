class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree=new int[n];
        Set<String> edge=new HashSet<>();
        List<Set<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        for(List<Integer> it:edges) {
            int u=it.get(0)-1;
            int v=it.get(1)-1;
            degree[u]++;
            degree[v]++;
            edge.add(Math.min(u,v)+","+Math.max(u,v));
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(degree[i]%2==1){
                odd.add(i);
            }
        }
        if(odd.size()>4||odd.size()%2==1){
            return false;
        }
        if(odd.size()==0){
            return true;
        }
        if(odd.size()==2){
            int a=odd.get(0);
            int b=odd.get(1);
            if(!edge.contains(Math.min(a,b)+","+Math.max(a,b))){
                return true;
            }
            for(int i=0;i<n;i++){
                if(i!=a&&i!=b&&!adj.get(a).contains(i)&&!adj.get(b).contains(i)){
                    return true;
                }
            }
            return false;
        }
        int a=odd.get(0);
        int b=odd.get(1);
        int c=odd.get(2);
        int d=odd.get(3);
        return(!edge.contains(Math.min(a,b)+","+Math.max(a,b))&&!edge.contains(Math.min(c,d)+","+Math.max(c,d)))||(!edge.contains(Math.min(a,c)+","+Math.max(a,c))&&!edge.contains(Math.min(b,d)+","+Math.max(b,d)))||(!edge.contains(Math.min(a,d)+","+Math.max(a,d))&&!edge.contains(Math.min(b,c)+","+ Math.max(b,c)));
    }
}