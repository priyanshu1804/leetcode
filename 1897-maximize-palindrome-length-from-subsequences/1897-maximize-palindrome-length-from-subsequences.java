class Solution {
    public int solve(int i,int j,String s,int[][] dp){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int val1=Integer.MIN_VALUE;
        int val2=Integer.MIN_VALUE;
        int val3=Integer.MIN_VALUE;
        if(s.charAt(i)==s.charAt(j)){
            val1=2+solve(i+1,j-1,s,dp);
        }else{
            val2=solve(i+1,j,s,dp);
            val3=solve(i,j-1,s,dp);
        }
        return dp[i][j]=Math.max(val1,Math.max(val2,val3));
    }
    public int longestPalindrome(String word1, String word2) {
        String s=word1+word2;
        int n=word1.length()+word2.length();
        int[][] dp=new int[n][n];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int max=0;
        for(int i=0;i<word1.length();i++){
            for(int j=word2.length()-1;j>=0;j--){
                if(word1.charAt(i)!=word2.charAt(j)){
                    continue;
                }
                int len=solve(i,word1.length()+j,s,dp);
                max=Math.max(max,len);
            }
        }
        return max;
    }
}