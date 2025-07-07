class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        int max=0;
        while(j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max=Math.max(max,set.size());
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}