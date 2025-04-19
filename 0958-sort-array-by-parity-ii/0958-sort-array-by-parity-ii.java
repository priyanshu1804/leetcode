class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }
        int[] ans=new int[n];
        int odd1=0;
        int even1=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                ans[i]=even.get(even1);
                even1++;
            }else{
                ans[i]=odd.get(odd1);
                odd1++;
            }
        }
        return ans;
    }
}