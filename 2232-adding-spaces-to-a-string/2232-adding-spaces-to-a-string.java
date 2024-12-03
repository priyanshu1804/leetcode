class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0;
        int j=0;
        StringBuilder s1=new StringBuilder();
        while(i<s.length()){
            if(j<spaces.length&&spaces[j]==i){
                s1.append(" ");
                j++;
            }
            s1.append(s.charAt(i));
            i++;
        }
        return s1.toString();
    }
}