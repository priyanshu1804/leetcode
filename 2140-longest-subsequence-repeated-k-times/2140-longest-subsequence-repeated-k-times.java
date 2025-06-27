class Solution {
    public boolean solve(String s,String t,int k){
        int c=0;
        int i=0;
        for(char ch:t.toCharArray()) {
            if(ch==s.charAt(i)) {
                if(++i==s.length()) {
                    i=0;
                    if(++c==k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans="";
        Queue<String> q=new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String c=q.poll();
            for(char ch='a';ch<='z';ch++){
                String n=c+ch;
                if(solve(n,s,k)){
                    ans=n;
                    q.add(n);
                }
            }
        }
        return ans;
    }
}