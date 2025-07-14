class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans=0;
        int x=capacityA;
        int y=capacityB;
        int i=0;
        int j=plants.length-1;
        while(i<=j){
            if(i==j){
                if(capacityA>=capacityB){
                    if(plants[i]>capacityA){
                        ans++;
                    }
                }else{
                    if(plants[j]>capacityB){
                        ans++;
                    }
                }
                break;
            }
            if(plants[i]>capacityA){
                ans++;
                capacityA=x;
            }
            if(plants[j]>capacityB){
                ans++;
                capacityB=y;
            }
            capacityB-=plants[j];
            capacityA-=plants[i];
            i++;
            j--;
        }
        return ans;
    }
}