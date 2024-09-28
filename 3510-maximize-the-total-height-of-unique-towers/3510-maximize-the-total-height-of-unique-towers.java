class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int max=maximumHeight[maximumHeight.length-1];
        long sum=max;
        for(int i=maximumHeight.length-2;i>=0;i--){
            if(maximumHeight[i]>=max){
                max--;
                if(max==0){
                    return -1;
                }
                sum+=max;
            }else{
                max=maximumHeight[i];
                sum+=maximumHeight[i];
            }
        }
        return sum;
    }
}