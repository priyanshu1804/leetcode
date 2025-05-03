class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int count=0;
            boolean flag=true;
            for(int j=0;j<tops.length;j++){
                if(tops[j]==i){
                    continue;
                }else if(bottoms[j]==i){
                    count++;
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                min=Math.min(min,count);
            }
        }
        for(int i=1;i<=6;i++){
            int count=0;
            boolean flag=true;
            for(int j=0;j<bottoms.length;j++){
                if(bottoms[j]==i){
                    continue;
                }else if(tops[j]==i){
                    count++;
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                min=Math.min(min,count);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}