class Solution{
    public int solve(int i,String s,int[] dp,int n){
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int[] freq=new int[26];
        int ans=5005;
        for(int j=i;j>=0;j--){
            freq[s.charAt(j)-'a']++;
            int max=-1;
            int min=5005;
            for(int k=0;k<26;k++){
                if(freq[k]>0){
                    min=Math.min(min,freq[k]);
                    max=Math.max(max,freq[k]);
                }
            }
            if(min==max){
                ans=Math.min(ans,1+solve(j-1,s,dp,n));
            }
        }
        return dp[i]=ans;
    }
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,s,dp,n);
    }
}
