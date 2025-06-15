class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()||st.size()%2==0||st.peek()!=nums[i]){
                st.push(nums[i]);
            }
            else{
                ans++;
            }
        }
        if(st.size()%2!=0){
            ans++;
        }
        return ans;
    }
}