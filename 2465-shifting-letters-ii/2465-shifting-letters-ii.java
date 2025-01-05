class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int m=shifts.length;
        int[] pre=new int[n];
        for(int i=0;i<m;i++){
            int x=shifts[i][0];
            int y=shifts[i][1];
            int dir=shifts[i][2];
            if(dir==1){
                for(int j=x;j<=y;j++){
                    pre[j]++;
                }
            }else{
                for(int j=x;j<=y;j++){
                    pre[j]--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int total=pre[i]%26;
            char ch=(char)((s.charAt(i)-'a'+total+26)%26+'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}