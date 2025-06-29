class Solution {
    public int solve(String s1,String s2){
        int i=0;
        while(i<s1.length()&&i<s2.length()&&s1.charAt(i)==s2.charAt(i)){
            i++;
        }
        return i;
    }
    public int[] longestCommonPrefix(String[] words) {
        int n=words.length;
        int pre[]=new int[n];
        int suf[]=new int[n];
        int cross[]=new int[n];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],solve(words[i],words[i-1]));
            int j=n-i-1;
            suf[j]=Math.max(suf[j+1],solve(words[j],words[j+1]));
            if(i>0&&i<n-1){
                cross[i]=solve(words[i+1],words[i-1]);
            }
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            if(i!=0){
                max=pre[i-1];
            }
            if(i!=n-1){
                max=Math.max(max,suf[i+1]);
            }
            max=Math.max(max,cross[i]);
            res[i]=max;
        }
        return res;
    }
}