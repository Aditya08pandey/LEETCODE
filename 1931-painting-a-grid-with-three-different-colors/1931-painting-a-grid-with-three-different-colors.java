class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // Step 1: Generate all valid column states
        List<int[]> states = new ArrayList<>();
        generateStates(m, 0, new int[m], states);

        // Step 2: Map states to integer keys for hashing
        Map<String, Integer> stateToIndex = new HashMap<>();
        for (int i = 0; i < states.size(); i++) {
            stateToIndex.put(Arrays.toString(states.get(i)), i);
        }

        // Step 3: Precompute valid transitions
        int size = states.size();
        List<Integer>[] transitions = new List[size];
        for (int i = 0; i < size; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (isValidTransition(states.get(i), states.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        // Step 4: Initialize DP array
        int[] dp = new int[size];
        Arrays.fill(dp, 1); // All states are valid for the first column

        // Step 5: DP for each column
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[size];
            for (int prev = 0; prev < size; prev++) {
                for (int next : transitions[prev]) {
                    newDp[next] = (newDp[next] + dp[prev]) % MOD;
                }
            }
            dp = newDp;
        }

        // Step 6: Sum all valid ways
        int result = 0;
        for (int count : dp) {
            result = (result + count) % MOD;
        }
        return result;
    }

    // Generate all column states with no adjacent cells having same color
    private void generateStates(int m, int idx, int[] curr, List<int[]> states) {
        if (idx == m) {
            states.add(curr.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (idx == 0 || curr[idx - 1] != color) {
                curr[idx] = color;
                generateStates(m, idx + 1, curr, states);
            }
        }
    }

    // Check if two column states are compatible (no matching cells row-wise)
    private boolean isValidTransition(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}