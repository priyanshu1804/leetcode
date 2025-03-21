class Solution {
    public boolean solve(String s,Set<String> set,Map<String,Integer> adj,HashSet<String> set1,List<List<String>> ingredients){
        if(!adj.containsKey(s)&&!set.contains(s)){
            return false;
        }
        if(set.contains(s)){
            return true;
        }
        if(set1.contains(s)){
            return false;
        }
        set1.add(s);
        if(adj.containsKey(s)){
            for(String ingredient:ingredients.get(adj.get(s))){
                if(!solve(ingredient,set,adj,set1,ingredients)){
                    return false;
                }
            }
        }
        set1.remove(s);
        return true;
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Integer> adj=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(String s:supplies){
            set.add(s);
        }
        for(int i=0;i<recipes.length;i++){
            adj.put(recipes[i],i);
        }
        List<String> ans=new ArrayList<>();
        for(String s:recipes){
            if(solve(s,set,adj,new HashSet<String>(),ingredients)){
                set.add(s);
                ans.add(s);
            }
        }
        return ans;
    }
}