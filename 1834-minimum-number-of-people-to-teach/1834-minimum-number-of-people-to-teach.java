class Solution{
    public boolean solve1(HashSet<Integer> first,HashSet<Integer> second){
        for(int it:first){
            if(second.contains(it)){
                return true;
            }
        }
        return false;
    }
    public int solve(int lang,int[][] friendships,HashMap<Integer,HashSet<Integer>> map){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<friendships.length;i++){
            int first=friendships[i][0];
            int second=friendships[i][1];
            HashSet<Integer> lang1=map.get(first);
            HashSet<Integer> lang2=map.get(second);
            if(!solve1(lang1,lang2)){
                if(!lang1.contains(lang)){
                    set.add(first);
                }
                if(!lang2.contains(lang)){
                    set.add(second);
                }
            }
        }
        return set.size();
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<languages.length;i++){
            map.put(i+1,new HashSet<>());
            for(int it:languages[i]){
                map.get(i+1).add(it);
            }
        } 
        int ans=languages.length;
        for(int i=1;i<=n;i++){
            ans=Math.min(ans,solve(i,friendships,map));
        }
        return ans;
    }
}