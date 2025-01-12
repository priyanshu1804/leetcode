class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        int n=locked.length();
        Stack<Integer> st=new Stack<>();
        Stack<Integer> st1=new Stack<>();
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'){
                st1.push(i);
            }else if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                if(!st.isEmpty()){
                    st.pop();
                }else if(!st1.isEmpty()){
                    st1.pop();
                }else{
                    return false;
                }
            }
        }
        while(!st.isEmpty()&&!st1.isEmpty()&&st.peek()<st1.peek()){
            st.pop();
            st1.pop();
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}