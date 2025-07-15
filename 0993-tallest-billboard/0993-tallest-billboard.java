class Solution {
    public int solve(int i,int sum1,int[] rods,int n,Map<String,Integer> dp){
        if(i==n){
            if(sum1==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        String key=i+","+sum1;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int x=rods[i]+solve(i+1,sum1+rods[i],rods,n,dp);
        int y=solve(i+1,sum1-rods[i],rods,n,dp);
        int z=solve(i+1,sum1,rods,n,dp);
        int ans=Math.max(x,Math.max(y,z));
        dp.put(key,ans);
        return ans;
    }
    public int tallestBillboard(int[] rods) {
        Map<String,Integer> dp=new HashMap<>();
        int n=rods.length;
        return solve(0,0,rods,n,dp); 
    }
}