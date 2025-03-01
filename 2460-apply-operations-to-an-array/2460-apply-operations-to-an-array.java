class Solution {
   void swap(int[] A, int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}

public int[] applyOperations(int[] A) {
    for (int i = 0, j = 0; i < A.length; ++i){
        if (i + 1 < A.length && A[i] == A[i + 1]){
            A[i] *= 2;
            A[i + 1] = 0;
        }
        if (A[i] != 0){
            swap(A,i,j);
            j++;
        }
    }   
    return A;
}
}