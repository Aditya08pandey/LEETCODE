class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        int N  = nums.length;
      
        Arrays.sort(nums);

        int score = nums[N-1] - nums[0];

        int ans   = score;

        
        for (int divider = 0; divider < N-1; divider++){

 
            int maximumAfterDivision = Math.max(nums[divider]    + k , nums[N-1] - k);
            int minimumAfterDivision = Math.min(nums[divider+1]  - k , nums[0]  + k);

            score = maximumAfterDivision - minimumAfterDivision;

            ans = Math.min(ans, score);
        }
        
        return ans;
    }
}