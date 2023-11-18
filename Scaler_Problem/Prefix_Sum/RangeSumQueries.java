package Scaler_Problem.Prefix_Sum;

import java.util.Arrays;

/*
 * Problem Statement*********
 You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */

/* 
 *******Explanation:******

The code calculates a prefix sum array prefixSum to efficiently find the sum of elements in the given range.
The findRangeSums method takes the input array A and 2D array B as input and returns an array containing 
the sum of elements for each query.
In the main method, an example array A and 2D array B with queries are provided, and the results are printed.
*/

public class RangeSumQueries {

    public static int[] findRangeSums(int[] A, int[][] queries) {
        int n = A.length;
        int m = queries.length;

        // Prefix sum array to efficiently calculate sums
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        // Array to store results for each query
        int[] result = new int[m];

        // Calculate sum for each query
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Calculate the sum based on prefix sum array
            if (left == 0) {
                result[i] = prefixSum[right];
            } else {
                result[i] = prefixSum[right] - prefixSum[left - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example array A
        int[] A = { 1, 2, 3, 4, 5 };

        // Example 2D array B with queries [L, R]
        int[][] queries = {
                { 0, 3 },
                { 1, 2 }
        };

       

        // Find and print the sum of elements for each query
        int[] result = findRangeSums(A, queries);

        // Print the results
        System.out.println("Array A: " + Arrays.toString(A));
        System.out.println("Queries:");
        for (int i = 0; i < queries.length; i++) {
            System.out.println("Query " + (i + 1) + ": " + Arrays.toString(queries[i]) + " -> Sum: " + result[i]);
        }

         int[] A1 = { 2, 2, 2 };
        int[][] quriesB = { { 0, 0 }, { 1, 2 } };
         int[] result2 = findRangeSums(A1, quriesB);

        // Print the results
        System.out.println("Array A1: " + Arrays.toString(A1));
        System.out.println("Queries:");
        for (int i = 0; i < quriesB.length; i++) {
            System.out.println("Query " + (i + 1) + ": " + Arrays.toString(quriesB[i]) + " -> Sum: " + result2[i]);
        }
    }
}