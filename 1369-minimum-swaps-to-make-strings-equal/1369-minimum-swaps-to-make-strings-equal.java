class Solution {
    public int minimumSwap(String s1, String s2) {
        int x=0;
        int y=0;
        int n=s1.length();
        int m=s2.length();
        if(n!=m){
            return -1;
        }
        for(int i=n-1;i>=0;i--){
            if(s1.charAt(i)=='x'&&s2.charAt(i)=='y'){
                x++;
            }else if(s1.charAt(i)=='y'&&s2.charAt(i)=='x'){
                y++;
            }
        }
        if(x%2!=y%2){
            return -1;
        }
        int ans=x/2+y/2;
        if(x%2==1){
            ans+=2;
        }
        return ans;
    }
}