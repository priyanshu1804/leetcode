class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr.add(grid[i][j]);
            }
        }
        int rem=arr.get(0)%x;
        for(int i=1;i<arr.size();i++){
            int y=arr.get(i)%x;
            if(rem!=y){
                return -1;
            }
        }
        Collections.sort(arr);
        int y=arr.get(arr.size()/2);
        int ans=0;
        for(int it:arr){
            ans+=Math.abs(y-it)/x;
        }
        return ans;
    }
}