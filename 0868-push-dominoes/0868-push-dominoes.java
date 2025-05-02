class Solution {
    public String pushDominoes(String dominoes) {
        char[] ch=dominoes.toCharArray();
        int n=ch.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='R'){
                count=n;
            }else if(ch[i]=='L'){
                count=0;
            }
            else{
                count=Math.max(count-1,0);
            }
            pre[i]=count;
        }
        for(int i=n-1;i>=0;i--){
            if(ch[i]=='L'){
                count=n;
            }else if(ch[i]=='R'){
                count=0;
            }
            else{
                count=Math.max(count-1,0);
            }
            suff[i]=count;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(pre[i]>suff[i]){
                sb.append('R');
            }else if(pre[i]<suff[i]){
                sb.append('L');
            }else{
                sb.append('.');
            }
        }
        return sb.toString();
    }
}