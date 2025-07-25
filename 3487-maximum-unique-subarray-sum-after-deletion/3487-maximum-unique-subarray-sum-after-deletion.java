class Solution {
    public int maxSum(int[] nums) {
       boolean hnn = false;
        for (int num : nums) {
            if (num >= 0) {
                hnn = true;
                break;
            }
        }
        
        if (hnn) {
            HashSet<Integer> seen = new HashSet<>();
            int sum = 0;
            for (int num : nums) {
                if (num >= 0 && !seen.contains(num)) {
                    seen.add(num);
                    sum += num;
                }
            }
            return sum;
        } else {
            int maxNeg = Integer.MIN_VALUE;
            for (int num : nums) {
                maxNeg = Math.max(maxNeg, num);
            }
            return maxNeg;
        }
}
}