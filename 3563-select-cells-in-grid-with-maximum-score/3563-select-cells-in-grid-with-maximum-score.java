class Solution {
    int[][] dp=new int[2001][101];
    public int solve(int i,int n,List<Integer> arr,Map<Integer,List<Integer>> map,int mask){
        if(i==n){
            return 0;
        }
        if(dp[mask][i]!=-1){
            return dp[mask][i];
        }
        int ans=0;
        for(int j:map.get(arr.get(i))){
            if((mask&(1<<j))==0){
                ans=Math.max(ans,arr.get(i)+solve(i+1,n,arr,map,(mask|(1<<j))));
            }
        }
        ans=Math.max(ans,solve(i+1,n,arr,map,mask));
        return dp[mask][i]=ans;
    }
    public int maxScore(List<List<Integer>> grid) {
        int n=grid.size();
        int m=grid.get(0).size();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                set.add(grid.get(i).get(j));
            }
        }
        List<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr,Collections.reverseOrder());
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.computeIfAbsent(grid.get(i).get(j),k->new ArrayList<>()).add(i);
            }
        }
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,arr.size(),arr,map,0);
    }
}