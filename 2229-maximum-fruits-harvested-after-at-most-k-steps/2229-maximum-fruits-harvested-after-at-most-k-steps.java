class Solution {
    public int solve(int left,int right,int start){
        int x=Math.abs(start-left)+(right-left);
        int y=Math.abs(start-right)+(right-left);
        return Math.min(x,y);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left=0;
        int max=0;
        int sum=0;
        for(int right=0;right<fruits.length;right++){
            sum+=fruits[right][1];
            while(left<=right&&solve(fruits[left][0],fruits[right][0],startPos)>k){
                sum-=fruits[left][1];
                left++;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}