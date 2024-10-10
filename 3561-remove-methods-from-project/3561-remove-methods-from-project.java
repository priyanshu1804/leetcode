class Solution {
    public void dfs(Set<Integer> set,ArrayList<ArrayList<Integer>> adj,int k){
        set.add(k);
        for(int it:adj.get(k)){
            if(!set.contains(it)){
                dfs(set,adj,it);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> set=new HashSet<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++){
            adj.get(invocations[i][0]).add(invocations[i][1]);
        }
        dfs(set,adj,k);
        boolean flag=false;
        for(int i=0;i<invocations.length;i++){
            int[] ans=invocations[i];
            if(set.contains(ans[1])&&!set.contains(ans[0])){
                flag=true;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(flag==true){
                ans.add(i);
            }else if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}