class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> set=new HashSet<>();
        String ans="";
        List<String> ans1=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            ans+=s.charAt(i);
            if(!set.contains(ans)){
                set.add(ans);
                ans1.add(ans);
                ans="";
            }
        }
        return ans1;
    }
}