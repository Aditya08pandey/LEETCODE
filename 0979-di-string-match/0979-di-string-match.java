class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int end = result.length - 1, start = 0;
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == 'I'){
                result[index] = start;   
                start++;
            }else{
                result[index] = end;
                end--;
            }
            index++;
        }
        result[result.length - 1] = start;
        return result;
    }
}