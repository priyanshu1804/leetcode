class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int count=0;
        for(int i=0;i<minutes;i++){
            count+=customers[i]*grumpy[i];
        }
        int max=count;
        for(int i=minutes;i<n;i++){
            count+=customers[i]*grumpy[i];
            count-=customers[i-minutes]*grumpy[i-minutes];
            max=Math.max(max,count);
        }
        int ans=max;
        for(int i=0;i<n;i++){
            ans+=customers[i]*(1-grumpy[i]);
        }
        return ans;
    }
}