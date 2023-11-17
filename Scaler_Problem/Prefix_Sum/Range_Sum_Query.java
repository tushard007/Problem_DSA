package Scaler_Problem.Prefix_Sum;

/*
 * Problem Statement
 You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */
public class Range_Sum_Query {
    public long[] rangeSum(int[] A, int[][] B) {
        int N = A.length;
      int M = B.length;
      long[] prefixSum = new long[N];
      long[] result = new long[M];

      // Calculate the prefix sum
      prefixSum[0] = A[0];
      for (int i = 1; i < N; i++) {
          prefixSum[i] = prefixSum[i - 1] + A[i];
      }

      // Process each query
      for (int i = 0; i < M; i++) {
          int L = B[i][0];
          int R = B[i][1];

          if (L == 0) {
              result[i] = prefixSum[R];
          } else {
              result[i] = prefixSum[R] - prefixSum[L - 1];
          }
      }

      return result;
  }
}
