import java.util.*;

class Solution {
    
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        
        if (!check(nums, queries, queries.length)) return -1;

        int l = 0, r = queries.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(nums, queries, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean check(int[] nums, int[][] queries, int m) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            int start = queries[i][0], end = queries[i][1], val = queries[i][2];
            arr[start] += val;
            if (end + 1 < n) arr[end + 1] -= val;
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            if (cur < nums[i]) return false;
        }
        return true;
    }
}