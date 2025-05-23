class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[] deltas = new long[n]; // represents how will change number after XOR
        for (int i = 0; i < n; i++) {
            deltas[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(deltas);
        for (int i = 0; i < n / 2; i++) {
            long temp = deltas[i];
            deltas[i] = deltas[n - i - 1];
            deltas[n - i - 1] = temp;
        }

        long res = 0;
        for (int num : nums) {
            res += num;
        }

        for (int startInd = 0; startInd < n - 1; startInd += 2) {
            long changingDelta = deltas[startInd] + deltas[startInd + 1]; // showing whether if would be beneficial if we XOR this two nodes 
            if (changingDelta > 0) {
                res += changingDelta;
            } else {
                break;
            }
        }

        return res;
    }
}