class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                st.pop();
            }
        }
        StringBuilder s1=new StringBuilder();
        while(!st.isEmpty()){
            s1.append(st.pop());
        }
        return s1.reverse().toString();
    }
}