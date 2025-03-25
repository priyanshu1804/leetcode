class Solution {
    public int countDistinctSections(List<int[]> intervals){
        intervals.sort(Comparator.comparingInt(a->a[0]));
        int mergedCount=0;
        int lastEnd=-1;
        for(int[] interval:intervals){
            if(interval[0]>=lastEnd){
                mergedCount++;
                lastEnd=interval[1];
            }else{
                lastEnd=Math.max(lastEnd,interval[1]);
            }
        }
        return mergedCount;
    }
    public boolean checkValidCuts(int n,int[][] rectangles) {
        List<int[]> xIntervals=new ArrayList<>();
        List<int[]> yIntervals=new ArrayList<>();
        for(int[] rect:rectangles){
            xIntervals.add(new int[]{rect[0],rect[2]});
            yIntervals.add(new int[]{rect[1],rect[3]});
        }
        return Math.max(countDistinctSections(xIntervals),countDistinctSections(yIntervals))>= 3;
    }
}