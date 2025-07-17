class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long x=mass;
        Arrays.sort(asteroids);
        for(int i=0;i<asteroids.length;i++){
            if(x>=asteroids[i]){
                x+=asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}