class Solution {
    public void solve(int i,int n,int k,int[] a,List<List<Integer>> ans,ArrayList<Integer>ds){
        if(k==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int j=i;j<n;j++){
            if(j>i&&a[j]==a[j-1]){
                continue;
            }
            if(a[j]<=k){
                ds.add(a[j]);
                solve(j+1,n,k-a[j],a,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       List<List<Integer>> ans=new ArrayList<>();
       int n=candidates.length;
       solve(0,n,target,candidates,ans,new ArrayList<>());
       return ans;
    }
}