class Solution {
    public String stringHash(String s, int k) {
        String ans="";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch='a';ch<='z';ch++){
            map.put(ch,ch-'a');
        }
        for(int i=0;i<s.length();i+=k){
            String st=s.substring(i,i+k);
            int x=0;
            for(int j=0;j<k;j++){
                x+=map.get(st.charAt(j));
            }
            x=x%26;
            char ch=(char)(x+'a');
            ans+=ch;
        }
        return ans;
    }
}