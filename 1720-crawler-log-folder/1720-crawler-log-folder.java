class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st=new Stack<String>();
        for(int i=0;i<logs.length;i++){
            if(!st.isEmpty()&&logs[i].equals("../")){
                st.pop();
            }
            else if(!logs[i].equals("./")&&!logs[i].equals("../")){
                st.push(logs[i]);
            }
        }
        int count=0;
        while(!st.isEmpty()){
            count++;
            st.pop();
        }
        return count;
    }
}