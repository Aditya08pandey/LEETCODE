import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> all = new ArrayList<>();
        
        // Merge lists with list index
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                all.add(new int[]{num, i});
            }
        }
        
        all.sort(Comparator.comparingInt(a -> a[0]));
        
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0, r = 0;
        int totalLists = nums.size();
        int uniqueListsInWindow = 0;
        int minRange = Integer.MAX_VALUE;
        int[] result = new int[]{0, 0};
        
        while (r < all.size()) {
            count.put(all.get(r)[1], count.getOrDefault(all.get(r)[1], 0) + 1);
            if (count.get(all.get(r)[1]) == 1) uniqueListsInWindow++;
            
            while (uniqueListsInWindow == totalLists) {
                int currentRange = all.get(r)[0] - all.get(l)[0];
                if (currentRange < minRange) {
                    minRange = currentRange;
                    result = new int[]{all.get(l)[0], all.get(r)[0]};
                }
                
                count.put(all.get(l)[1], count.get(all.get(l)[1]) - 1);
                if (count.get(all.get(l)[1]) == 0) uniqueListsInWindow--;
                l++;
            }
            
            r++;
        }
        
        return result;
    }
}