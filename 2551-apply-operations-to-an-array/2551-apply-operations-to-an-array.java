class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr.add(nums[i]);
            }
        }
        int j=arr.size();
        for(int i=0;i<j;i++){
            nums[i]=arr.get(i);
        }
        while(j<n){
            nums[j]=0;
            j++;
        }
        return nums;
    }
}