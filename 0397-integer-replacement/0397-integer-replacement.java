class Solution {
    public int solve(long n,HashMap<Long,Integer> dp){
        if(n==1){
            return 0;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int even=Integer.MAX_VALUE;
        int odd1=Integer.MAX_VALUE;
        int odd2=Integer.MAX_VALUE;
        if(n%2==0){
            even=1+solve(n/2,dp);
        }else{
            odd1=1+solve(n+1,dp);
            odd2=1+solve(n-1,dp);
        }
        int ans=Math.min(even,Math.min(odd1,odd2));
        dp.put(n,ans);
        return ans;
    }
    public int integerReplacement(int n) {
        HashMap<Long,Integer> dp=new HashMap<>();
        return solve(n,dp);
    }
}