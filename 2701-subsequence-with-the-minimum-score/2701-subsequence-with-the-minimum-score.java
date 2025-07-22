class Solution {
    public int minimumScore(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] pre=new int[n];
        int[] suff=new int[n];
        int count=0;
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(s.charAt(i)==t.charAt(j)){
                count++;
                j++;
            }
            pre[i]=count;
            i++;
        }
        while(i<n){
            pre[i]=count;
            i++;
        }
        int ans=m-count;
        i=n-1;
        j=m-1;
        count=0;
        while(i>=0&&j>=0){
            if(s.charAt(i)==t.charAt(j)){
                count++;
                j--;
            }
            suff[i]=count;
            i--;
        }
        while(i>=0){
            suff[i]=count;
            i--;
        }
        if(count==m){
            return 0;
        }
        ans=Math.min(ans,m-count);
        for(int k=0;k<(n-1);k++){
            ans=Math.min(ans,m-(pre[k]+suff[k+1]));
        }
        return ans;
    }
}