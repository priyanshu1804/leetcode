class Solution {
    public void dfs(HashMap<Integer,ArrayList<Integer>> map,int node,boolean[] vis,int[] nums){
        if(vis[nums[node]]){
            return;
        }
        vis[nums[node]]=true;
        for(int it:map.getOrDefault(node,new ArrayList<>())){
            dfs(map,it,vis,nums);
        }
    }
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int one=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                one=i;
                break;
            }
        }
        if(one==-1){
            return ans;
        }
        for(int i=0;i<n;i++){
            map.computeIfAbsent(parents[i],x->new ArrayList<>()).add(i);
        }
        boolean[] vis=new boolean[1000000];
        int min=1;
        while(one!=-1){
            dfs(map,one,vis,nums);
            while(vis[min]){
                min++;
            }
            ans[one]=min;
            one=parents[one];
        } 
        return ans;
    }
}