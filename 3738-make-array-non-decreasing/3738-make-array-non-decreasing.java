class Solution {
    public int maximumPossibleSize(int[] nums) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()||st.peek()<=nums[i]){
                //System.out.println(nums[i]);
                st.push(nums[i]);
            }
        }
        return st.size();
    }
}