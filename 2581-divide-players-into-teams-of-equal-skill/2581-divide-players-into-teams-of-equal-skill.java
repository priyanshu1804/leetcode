class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long count=skill[0]+skill[skill.length-1];
        long ans=skill[0]*skill[skill.length-1];
        int i=1;
        int j=skill.length-2;
        while(i<j){
            if((long)(skill[i]+skill[j])==count){
                ans+=(long)(skill[i]*skill[j]);
            }else{
                return -1;
            }
            i++;
            j--;
        }
        return ans;
    }
}