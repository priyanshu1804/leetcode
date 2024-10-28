class Solution {
    public boolean solve(int[] nums,int target){
        if(target<0){
            return false;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int it:nums){
            if(set.contains(it)){
                continue;
            }
            int curr=it;
            int currlength=1;
            while(true){
                if((long)curr*(long)curr>1e5){
                    break;
                }
                if(solve(nums,curr*curr)){
                    curr*=curr;
                    set.add(curr);
                    currlength++;
                }else{
                    break;
                }
                max=Math.max(max,currlength);
            }
        }
        if(max<2){
            return -1;
        }
        return max;
    }
}