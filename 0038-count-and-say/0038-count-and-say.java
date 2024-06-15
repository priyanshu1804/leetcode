class Solution {
    public String helper(String str){
        StringBuilder sb=new StringBuilder();
        int count;
        int n=str.length();
        for(int i=0,j=0;i<n;i=j){
            while(j<n&&str.charAt(j)==str.charAt(i)){
                j++;
            }
            sb.append(j-i).append(str.charAt(i));
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        String str="1";
        while(n-->1){
            str=helper(str);
        }
        return str;
    }
}