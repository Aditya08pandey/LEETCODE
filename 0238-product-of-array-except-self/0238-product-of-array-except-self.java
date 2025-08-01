class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] ans=new int[n];

        int preProduct=1;
        
        for(int i=0;i<n;i++){
            ans[i]=preProduct;
            preProduct*=nums[i];
        }

        int postProduct=1;
        for (int i =n - 1; i >= 0; i--) {
            ans[i] *= postProduct;
            postProduct *= nums[i];
        }
        return ans;
    }
}