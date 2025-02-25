class Solution {
    private boolean isSubsequence(String base, String subseq) {
        int i_base = 0;
        for (int i = 0 ; i < subseq.length() ; ++i) {
            while (i_base < base.length() && base.charAt(i_base) != subseq.charAt(i)) {
                ++i_base;
            }
            if (i_base == base.length()) {
                return false;
            }
            ++i_base;
        }
        return true;
    }
    
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0 ; i < strs.length ; ++i) {
            boolean broken = false;
            for (int j = 0 ; j < strs.length ; ++j) {
                if (i == j) continue;
                if (isSubsequence(strs[j], strs[i])) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
}