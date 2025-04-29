class Solution {
    public long countSubarrays(int[] nums, int k) {
       int n=nums.length;      
       int R=0,L=0;
       long count=0;

       HashMap<Integer, Integer> hm=new HashMap<>();        
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        while(R<n){          
            hm.put(nums[R], hm.getOrDefault(nums[R], 0)+1);
            while (hm.getOrDefault(max, 0) >= k){
                count+=n-R;
                hm.put(nums[L], hm.get(nums[L])-1);
                L++;
            }
            R++;
        }
        return count;
    }
}