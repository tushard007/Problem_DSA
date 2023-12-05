package Scaler_Problem.Prefix_Sum;

import java.util.Arrays;

public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int n = nums.length;

        // Check for empty array
        if (n == 0) {
            return new int[0];
        }

        int[] runningSum = new int[n];
        runningSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }

    public static void main(String[] args) {
        // Example array
        int[] nums = {1, 2, 3, 4, 5};

        // Calculate and print the running sum
        int[] result = runningSum(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Running Sum Array: " + Arrays.toString(result));
    }
}