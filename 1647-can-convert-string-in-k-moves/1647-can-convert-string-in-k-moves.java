class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            int diff=(int)(t.charAt(i)-s.charAt(i));
            if(diff<0){
                diff=diff+26;
            }
            if(diff>0&&diff+count[diff]*26>k){
                return false;
            }
            count[diff]++;
        }
        return true;
    }
}