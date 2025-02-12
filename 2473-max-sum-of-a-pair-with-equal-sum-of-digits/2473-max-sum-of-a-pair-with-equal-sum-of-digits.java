class Solution {
    public int solve(int n){
        int ans=0;
        while(n>0){
            ans+=n%10;
            n/=10;
        }
        return ans;
    }
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int key=solve(nums[i]);
            if(map.containsKey(key)){
                max=Math.max(max,map.get(key)+nums[i]);
            }
            map.put(key,nums[i]);
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}