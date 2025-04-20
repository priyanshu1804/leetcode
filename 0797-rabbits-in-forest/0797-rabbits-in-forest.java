class Solution {
    public int numRabbits(int[] answers) {
        int n=answers.length;
        int ans=0;
        int count=0;
        Arrays.sort(answers);
        for(int i=0;i<n;i++){
            if(answers[i]==0){
                ans++;
            }
            else if(i==0||count==0||answers[i]!=answers[i-1]){
                ans+=answers[i]+1;
                count=answers[i];
            }else{
                count--;
            }
        }
        return ans;
    }
}