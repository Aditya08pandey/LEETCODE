import java.util.HashMap;

class Solution {
    public int maxDifference(String s) {
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int count : freq.values()) {
            if ((count & 1) == 1) {
                oddMax = Math.max(oddMax, count);
            } else {
                evenMin = Math.min(evenMin, count);
            }
        }

        return oddMax - evenMin;
    }
}