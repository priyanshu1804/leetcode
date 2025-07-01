class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int n=enemyEnergies.length;
        Arrays.sort(enemyEnergies);
        if(currentEnergy<enemyEnergies[0]){
            return 0;
        }
        long sum=currentEnergy;
        for(int i=n-1;i>0;i--){
            sum+=enemyEnergies[i];
        }
        return sum/enemyEnergies[0];
    }
}