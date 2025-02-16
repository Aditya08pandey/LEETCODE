import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] res = new int[size];
        boolean[] used = new boolean[n + 1];

        if (backtrack(res, used, n, 0)) {
            return res;
        }
        return new int[0]; 
    }

    private boolean backtrack(int[] res, boolean[] used, int n, int index) {
        if (index == res.length) return true;
        if (res[index] != 0) return backtrack(res, used, n, index + 1);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) { // '1' occurs once
                res[index] = 1;
                used[1] = true;
                if (backtrack(res, used, n, index + 1)) return true;
                res[index] = 0;
                used[1] = false;
            } else {
                int secondIndex = index + num;
                if (secondIndex < res.length && res[secondIndex] == 0) {
                    res[index] = res[secondIndex] = num;
                    used[num] = true;
                    if (backtrack(res, used, n, index + 1)) return true;
                    res[index] = res[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }}