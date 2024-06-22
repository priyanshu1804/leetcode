class Solution {
    public boolean palindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int count(int i,String s,int[] dp){
        int n=s.length();
        if(i==n){
            return -1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(palindrome(i,j,s)==true){
                int left=1+count(j+1,s,dp);
                min=Math.min(min,left);
            }
        }
        return dp[i]=min;
    }
    public int minCut(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return count(0,s,dp);
    }
}