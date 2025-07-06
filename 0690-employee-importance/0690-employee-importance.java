/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int dfs(int id,Map<Integer,Employee> map){
        int ans=map.get(id).importance;
        for(int it:map.get(id).subordinates){
            ans+=dfs(it,map);
        }
        return ans;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee it:employees){
            map.put(it.id,it);
        }
        return dfs(id,map);
    }
}