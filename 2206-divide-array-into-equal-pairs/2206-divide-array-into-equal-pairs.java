class Solution {
       public boolean divideArray(int[] nums) {
        int[] cnt = new int[501];
        for (int n : nums)
            ++cnt[n];
        return IntStream.of(cnt).allMatch(n -> n % 2 == 0);
    }
}