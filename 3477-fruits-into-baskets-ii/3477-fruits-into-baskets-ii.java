class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] ud = new boolean[n];
        int upd = 0;

      
        for (int i = 0; i < n; i++) {
            boolean pd = false;
        
            for (int j = 0; j < n; j++) {
                if (!ud[j] && baskets[j] >= fruits[i]) {
                    ud[j] = true;
                    pd = true;
                    break;  
                }
            }
            
            if (!pd) {
                upd++;
            }
        }
        return upd;
    }
}