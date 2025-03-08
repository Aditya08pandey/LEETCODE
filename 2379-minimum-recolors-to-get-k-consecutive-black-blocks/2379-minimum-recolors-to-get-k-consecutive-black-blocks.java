class Solution {
        public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        for (int lo = -1, hi = 0, white = 0; hi < blocks.length(); ++hi) {
            white += blocks.charAt(hi) == 'W' ? 1 : 0;
            if (hi - lo >= k) { // the window reaches size of k.
                min = Math.min(min, white); // update  minimum.
                // slide 1 step right the lower bound of the sliding
                // window and update the value of white count.
                white -= blocks.charAt(++lo) == 'W' ? 1 : 0;
            }
        }
        return min;
    }
}