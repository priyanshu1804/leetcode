class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> set=new HashMap<>();
        int n=queries.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(queries[i][0])){
                int x=map.get(queries[i][0]);
                set.put(x,set.getOrDefault(x,0)-1);
                if(set.get(x)==0){
                    set.remove(x);
                }
            }
            map.put(queries[i][0],queries[i][1]);
            set.put(queries[i][1],set.getOrDefault(queries[i][1],0)+1);
            ans[i]=set.size();
        }
        return ans;
    }
}