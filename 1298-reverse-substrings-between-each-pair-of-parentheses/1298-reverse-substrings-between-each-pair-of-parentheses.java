class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                ArrayList<Character> sb=new ArrayList<>();
                while(st.peek()!='('){
                    sb.add(st.pop());
                }
                st.pop();
                int k=0;
                while(k<sb.size()){
                    st.add(sb.get(k));
                    k++;
                }
            }else{
                st.push(ch);
            }
        }
        StringBuilder newString=new StringBuilder();
        while(!st.isEmpty()){
            newString.append(st.pop());
        }
        return newString.reverse().toString();
    }
}