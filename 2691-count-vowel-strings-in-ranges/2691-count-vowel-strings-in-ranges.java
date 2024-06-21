class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        
        int N = words.length;
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            if(hs.contains(words[i].charAt(0)) && hs.contains(words[i].charAt(words[i].length()-1))){
                arr[i] = 1;
            }
        }
        
        int[] prefix = new int[N];
        prefix[0] = arr[0];
        for(int i=1; i<N; i++) {
            prefix[i] = prefix[i-1]+arr[i];
        }
        
        int[] ansArr = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int[] q = queries[i];
            int s = q[0];
            int e = q[1];
            
            int cnt = prefix[e];
            
            if(s-1>=0) {
                cnt -= prefix[s-1];
            }
            
            ansArr[i] = cnt;
        }
        
        return ansArr;
    }
}