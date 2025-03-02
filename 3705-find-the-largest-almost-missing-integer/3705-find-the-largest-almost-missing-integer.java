class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq=new int[51];
        for(int i=0;i<=nums.length-k;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int it:set){
                freq[it]++;
            }
        }
        for(int i=50;i>=0;i--){
            if(freq[i]==1){
                return i;
            }
        }
        return -1;
    }
}