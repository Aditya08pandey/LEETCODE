class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix == null)
             return 0;
        int ret = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    continue;
                if(i >= 1 && j >= 1){
                    matrix[i][j] = Math.min(
                     Math.min(matrix[i-1][j-1] + 1,matrix[i-1][j] + 1),
                        matrix[i][j-1] + 1);
                } 
                ret += matrix[i][j];
               // System.out.println(i + " " + j + " " + matrix[i][j]);
            }
        }
        return ret;
    }
}