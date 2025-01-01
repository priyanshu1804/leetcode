class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] pre=new int[s.length()];
        int[] suff=new int[s.length()];
        for(int i=0;i<n;i++){
            if(i==0){
                if(s.charAt(i)=='0'){
                    pre[0]=1;
                }else{
                    pre[0]=0;
                }
            }else{
                if(s.charAt(i)=='0'){
                    pre[i]=1+pre[i-1];
                }else{
                    pre[i]=pre[i-1];
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                if(s.charAt(i)=='1'){
                    suff[n-1]=1;
                }else{
                    suff[n-1]=0;
                }
            }else{
                if(s.charAt(i)=='1'){
                    suff[i]=1+suff[i+1];
                }else{
                    suff[i]=suff[i+1];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            max=Math.max(max,suff[i+1]+pre[i]);
        }
        return max;
    }
}