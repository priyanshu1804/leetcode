class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        if(s.length()>=1){
            sb.append(s.charAt(0));
        }
        if(s.length()>=2){
            sb.append(s.charAt(1));
        }
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)&&s.charAt(i-2)==s.charAt(i)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}