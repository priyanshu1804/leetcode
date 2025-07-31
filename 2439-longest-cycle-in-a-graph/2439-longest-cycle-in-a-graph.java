class Solution {
    int max=-1;
    HashSet<Integer> set=new HashSet<>();
    public int longestCycle(int[] edges) {
        int n=edges.length;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                int node=i;
                HashMap<Integer,Integer> map=new HashMap<>();
                Queue<Integer> q=new LinkedList<>();
                q.add(node);
                int level=0;
                while(!q.isEmpty()){
                    int parent=q.remove();
                    map.put(parent,level);
                    level++;
                    int child=edges[parent];
                    if(map.containsKey(child)){
                        max=Math.max(max,level-map.get(child));
                    }
                    if(!set.contains(child)&&child!=-1){
                        set.add(child);
                        q.add(child);
                    }
                }
            }
        }
        return max;
    }
}