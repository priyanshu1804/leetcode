class Solution {
    public int maximumCount(int[] nums) {
        int negCnt=0,zeroCnt=0,posCnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeroCnt++;
            else if(nums[i]>0) posCnt++;
            else negCnt++;
        }
        return Math.max(posCnt,negCnt);
    }
}