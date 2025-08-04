class Solution {
    public int minMovesToMakePalindrome(String s) {
        int ans=0;
        int start=0;
        int end=s.length()-1;
        char[] ch=s.toCharArray();
        while(start<end){
            int x=end;
            if(ch[start]==ch[end]){
                start++;
                end--;
                continue;
            }
            while(ch[start]!=ch[x]){
                x--;
            }
            if(start==x){
                char temp=ch[x];
                ch[x]=ch[x+1];
                ch[x+1]=temp;
                ans++;
            }
            else{
                while(x<end){
                    char temp=ch[x];
                    ch[x]=ch[x+1];
                    ch[x+1]=temp;
                    ans++;
                    x++;
                }
            }
        }
        return ans;
    }
}