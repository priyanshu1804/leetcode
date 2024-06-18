class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        int[][] job=new int[n][2];
        for(int i=0;i<n;i++){
            job[i][0]=difficulty[i];
            job[i][1]=profit[i];
        } 
        Arrays.sort(job,(a,b)->a[0]-b[0]);
        Arrays.sort(worker);
        int i=0;
        int max=0;
        int count=0;
        for(int it:worker){
            while(i<n&&it>=job[i][0]){
                max=Math.max(max,job[i][1]);
                i++;
            }
            count+=max;
        }
        return count;
    }
}