class Solution {
    public String largestGoodInteger(String num) {
        char maxdigit='\0';
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1)&&num.charAt(i)==num.charAt(i+2)){
                maxdigit=(char)Math.max(maxdigit,num.charAt(i));
            }
        }
        return maxdigit=='\0'?"":new String(new char[]{maxdigit,maxdigit,maxdigit});
    }
}