class Solution {
    int n;
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public int solve(int idx,int[] nums,boolean[] vis,HashMap<String,Integer> dp){
        String key=Arrays.toString(vis);
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int max=0;
        for(int i=0;i<n-1;i++){
            if(vis[i]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(vis[j]){
                    continue;
                }
                vis[i]=true;
                vis[j]=true;
                int ans=idx*gcd(nums[i],nums[j]);
                int x=solve(idx+1,nums,vis,dp);
                max=Math.max(max,ans+x);
                vis[i]=false;
                vis[j]=false;
            }
        }
        dp.put(key,max);
        return max;
    }
    public int maxScore(int[] nums) {
        n=nums.length;
        boolean[] vis=new boolean[n];
        HashMap<String,Integer> dp=new HashMap<>();
        return solve(1,nums,vis,dp);
    }
}