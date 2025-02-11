class Solution {
    public String removeOccurrences(String s, String part) {
        int k=part.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        int i=0;
        int j=k-1;
        while(i<=j&&j<sb.length()){
            String s1=sb.substring(i,j+1);
            if(s1.equals(part)){
                sb.delete(i,j+1);
                i=0;
                j=k-1;
            }else{
                i++;
                j++;
            }
        }
        return sb.toString();
    }
}