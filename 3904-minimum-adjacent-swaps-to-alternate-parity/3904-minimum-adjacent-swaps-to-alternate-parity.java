class Solution {
    public int minSwaps(int[] nums) {
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even.add(i);
            }else{
                odd.add(i);
            }
        }
        if(Math.abs(even.size()-odd.size())>1){
            return -1;
        }
        int ans=Integer.MAX_VALUE;
        if(even.size()>=odd.size()){
            int count=0;
            for(int i=0;i<even.size();i++){
                count+=Math.abs(even.get(i)-2*i);
            }
            ans=Math.min(ans,count);
        }
        if(odd.size()>=even.size()){
            int count=0;
            for(int i=0;i<odd.size();i++){
                count+=Math.abs(odd.get(i)-2*i);
            }
            ans=Math.min(ans,count);
        }
        return ans;
    }
}