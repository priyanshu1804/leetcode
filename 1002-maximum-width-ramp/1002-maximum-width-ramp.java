class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer>st=new Stack<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()||nums[st.peek()]>nums[i]){
                st.push(i);
            }
        }
        for(int i=nums.length-1;i>max;i--){
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i]){
                max=Math.max(max,i-st.peek());
                st.pop();
            }
        }
        return max;
    }
}