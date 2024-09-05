class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int roll:rolls){
            sum+=roll;
        }
        int remain=mean*(n+rolls.length)-sum;
        if(remain>6*n||remain<n){
            return new int[0];
        }
        int remainmean=remain/n;
        int ans=remain%n;
        int[] result=new int[n];
        Arrays.fill(result,remainmean);
        for(int i=0;i<ans;i++){
            result[i]++;
        }
        return result;
    }
}