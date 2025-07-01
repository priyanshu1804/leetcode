class Solution {
    public String resultingString(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()) {
            if(st.isEmpty()){
                st.push(ch);
            }else{
                char top=st.peek();
                if(solve(ch,top)){
                    st.pop(); 
                }else{
                    st.push(ch);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    public boolean solve(char char1,char char2){
        int difference=Math.abs(char1-char2);
        if(difference==1){
            return true;
        }
        return (char1=='a'&&char2=='z')||(char1=='z'&&char2=='a');
    }
}