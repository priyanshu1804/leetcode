class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2){
        int m=str1.length();
        int n=str2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        StringBuilder sb=new StringBuilder();
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
    // private String solve(String str1,String str2,int i,int j){
    //     if(i==str1.length()){
    //         return str2.substring(j);
    //     }
    //     if(j==str2.length()){
    //         return str1.substring(i);
    //     }
    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }
    //     if(str1.charAt(i)==str2.charAt(j)){
    //         return dp[i][j]=str1.charAt(i)+solve(str1,str2,i+1,j+1);
    //     }else{
    //         String pick=str1.charAt(i)+solve(str1,str2,i+1,j);
    //         String notpick=str2.charAt(j)+solve(str1,str2,i,j+1);
    //         return dp[i][j]=(pick.length()<notpick.length())?pick:notpick;
    //     }
    // }
}
