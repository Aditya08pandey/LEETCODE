class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int squareNum = i * i;
            if (isPartition(squareNum + "", i)) {
                sum+=squareNum;
            }
        }
        return sum;
    }

    private boolean isPartition(String str, int value) {
        if (value == 0 && str == "") return true;
        if (value < 0) return false;
        boolean ans = false;
        for (int i = 0; i < str.length(); i++) {
            String leftStr = str.substring(0, i+1);
            String rightStr = str.substring(i+1, str.length());
            int leftNum = Integer.parseInt(leftStr);
            boolean isPossible = isPartition(rightStr, value -leftNum);
            if (isPossible) {
                ans = true;
                break;
            }
        }
        return ans;
    }
}