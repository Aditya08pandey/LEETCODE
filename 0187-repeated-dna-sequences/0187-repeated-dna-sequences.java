class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> n2d = new HashMap<>();
        n2d.put('A', 0);
        n2d.put('C', 1);
        n2d.put('G', 2);
        n2d.put('T', 3);
        Set<Integer> candidates = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < s.length(); i++)
        {
           
            cur %= 1<<18;                
            cur = cur * 4 + n2d.get(s.charAt(i));
            if (i < 9) continue;
            if (candidates.contains(cur))
            {
                duplicates.add(s.substring(i-9, i+1));
            }
            else
            {
                candidates.add(cur);
            }
        }
        return new ArrayList<String>(duplicates);
    }
}