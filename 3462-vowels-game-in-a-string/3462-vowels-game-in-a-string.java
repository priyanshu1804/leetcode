class Solution {
    public boolean doesAliceWin(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count++;
            }
        }
        if(count>0){
            return true;
        }
        return false;
    }
}