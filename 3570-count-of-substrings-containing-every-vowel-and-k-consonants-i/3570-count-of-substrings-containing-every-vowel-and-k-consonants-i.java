class Solution {
    public int countOfSubstrings(String word, int k) {
        int i=0;
        int j=0;
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int consonants=0;
        while(j<word.length()){
            char currentChar=word.charAt(j);
            if(set.contains(currentChar)){
                map.put(currentChar,map.getOrDefault(currentChar,0)+1);
            }else{
                consonants++;
            }
            while(consonants>k){
                char leftChar=word.charAt(i);
                if(set.contains(leftChar)){
                    map.put(leftChar,map.get(leftChar)-1);
                    if(map.get(leftChar)==0){
                        map.remove(leftChar);
                    }
                }else{
                    consonants--;
                }
                i++;
            }
            if(map.size()==5&&consonants==k){
                ans++;
                int l=i;
                HashMap<Character,Integer> map1=new HashMap<>(map);
                int consonants1=consonants;
                while(map1.size()==5){
                    if(map1.containsKey(word.charAt(l))){
                        map1.put(word.charAt(l),map1.get(word.charAt(l))-1);
                        if (map1.get(word.charAt(l))==0){
                            map1.remove(word.charAt(l));
                        }
                    }else{
                        consonants1--;
                    }
                    l++;
                    if(consonants1==k&&map1.size()==5){
                        ans++;
                    }
                    if(consonants1<k){
                        break;
                    }
                }
            }
            j++;
        }
        return ans;
    }
}
