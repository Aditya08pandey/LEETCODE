class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while (i < n) {
        
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                sb.setCharAt(i, '!'); 
                
                for (int j = i - 1; j >= 0; j--) {
                    if ((sb.charAt(j) < '0' || sb.charAt(j) > '9') && sb.charAt(j) != '!') {
                        sb.setCharAt(j, '!'); 
                        break;
                    }
                }
            }
            i++;
        }
       
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < n; k++) {
            if (sb.charAt(k) != '!') res.append(sb.charAt(k));
        }
        return res.toString();
    }
}