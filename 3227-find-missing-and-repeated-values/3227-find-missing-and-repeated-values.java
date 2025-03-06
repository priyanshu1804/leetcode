class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size=grid.length*grid[0].length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int repeat=0;
        int count=0;
        for(int i=1;i<=size;i++){
            if(!map.containsKey(i)){
                count=i;
            }
            if(map.getOrDefault(i,0)>1){
                repeat=i;
            }
        }
        int[] arr=new int[2];
        arr[0]=repeat;
        arr[1]=count;
        return arr;
    }
}
