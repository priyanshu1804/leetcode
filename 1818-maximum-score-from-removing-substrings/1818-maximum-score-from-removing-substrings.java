class Solution {
    public int maximumGain(String s, int x, int y) {
        int sum=0;
        if(x>y){
            Stack<Character> st=new Stack<>();
            for(int i=0;i<s.length();i++){
                if(!st.isEmpty()&&s.charAt(i)=='b'&&st.peek()=='a'){
                    st.pop();
                    sum+=x;
                }
                else{
                    st.push(s.charAt(i));
                }
            }
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            String str=sb.reverse().toString();
            for(int i=0;i<str.length();i++){
                if(!st.isEmpty()&&str.charAt(i)=='a'&&st.peek()=='b'){
                    st.pop();
                    sum+=y;
                }
                else{
                    st.push(str.charAt(i));
                }
            }
        }else{
            Stack<Character> st=new Stack<>();
            for(int i=0;i<s.length();i++){
                if(!st.isEmpty()&&s.charAt(i)=='a'&&st.peek()=='b'){
                    st.pop();
                    sum+=y;
                }
                else{
                    st.push(s.charAt(i));
                }
            }
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            String str=sb.reverse().toString();
            for(int i=0;i<str.length();i++){
                if(!st.isEmpty()&&str.charAt(i)=='b'&&st.peek()=='a'){
                    st.pop();
                    sum+=x;
                }
                else{
                    st.push(str.charAt(i));
                }
            }
        }
        return sum;
    }
}