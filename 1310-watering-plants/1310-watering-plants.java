class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count=0;
        int n=plants.length;
        int x=capacity;
        for(int i=0;i<n;i++){
            if(x>=plants[i]){
                x-=plants[i];
                count++;
            }else{
                count+=(i+i+1);
                x=capacity-plants[i];
            }
        }
        return count;
    }
}