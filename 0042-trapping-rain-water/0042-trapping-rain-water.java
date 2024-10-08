class Solution {
    public int trap(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&height[st.peek()]<height[i]){
                int top=height[st.peek()];
                st.pop();
                if(st.isEmpty()){
                    break;
                }
                int width=i-st.peek()-1;
                int length=Math.min(height[i],height[st.peek()])-top;
                ans+=length*width;
            }
            st.push(i);
        }
        return ans;
    }
}