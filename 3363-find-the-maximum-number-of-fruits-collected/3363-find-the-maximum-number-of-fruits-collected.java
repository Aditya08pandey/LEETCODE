class Solution {
    int dp[][];

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        return child1(fruits) + child2(fruits, 0, n - 1, n) + child3(fruits, n - 1, 0, n);

    }

    int child1(int[][] fruits) {
        int ans = 0;
        for (int i = 0; i < fruits.length; i++) {
            ans += fruits[i][i];
            fruits[i][i] = 0;
        }
        return ans;
    }

    int child2(int[][] fruits, int i, int j, int n) {
        if (i >= n || i < 0 || j >= n || j < 0) {
            return 0;
        }
        if (i > j || i == j) {
            return 0;
        }

        if (i == n - 1 && j == n - 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = fruits[i][j] + child2(fruits, i + 1, j, n);
        int b = fruits[i][j] + child2(fruits, i + 1, j + 1, n);
        int c = fruits[i][j] + child2(fruits, i + 1, j - 1, n);

        return dp[i][j] = Math.max(Math.max(a, b), c);
    }

    int child3(int[][] fruits, int i, int j, int n) {
        if (i >= n || i < 0 || j >= n || j < 0) {
            return 0;
        }
        if (j > i || i == j) {
            return 0;
        }

        if (i == n - 1 && j == n - 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = fruits[i][j] + child3(fruits, i, j + 1, n);
        int rightUp = fruits[i][j] + child3(fruits, i - 1, j + 1, n);
        int rightDown = fruits[i][j] + child3(fruits, i + 1, j + 1, n);

        return dp[i][j] = Math.max(Math.max(right, rightUp), rightDown);
    }

}