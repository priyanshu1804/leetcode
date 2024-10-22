class Solution {
    public int check(String s,int i){
        int j=i;
        while(i<s.length()&&s.charAt(i)==s.charAt(j)){
            i++;
        }
        return i-j;
    }
    public boolean solve(String s,String it){
        int i=0;
        int j=0;
        while(i<s.length()&&j<it.length()){
            if(s.charAt(i)!=it.charAt(j)){
                return false;
            }
            int len1=check(s,i);
            int len2=check(it,j);
            if(len1<len2||len1>len2&&len1<3){
                return false;
            }
            i+=len1;
            j+=len2;
        }
        return (i==s.length()&&j==it.length());
    }
    public int expressiveWords(String s, String[] words) {
        int count=0;
        for(String it:words){
            if(solve(s,it)){
                count++;
            }
        }
        return count;
    }
}