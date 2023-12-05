package Scaler_Problem.Sliding_Window;

import java.util.List;

public class Sliding window template {

   private static W slidingWindowFixed(List<T> input, int windowSize) {
    W ans = window = input[0..windowSize);
    for (int right = windowSize; right < input.size(); ++right) {
        int left = right - windowSize;
        remove input.get(left) from window
        append input.get(right) to window
        ans = optimal(ans, window);
    }
    return ans;
}
============================================================
private static W slidingWindowFlexibleLongest(List<T> input) {
    initialize window, ans
    int left = 0;
    for (int right = 0; right < input.size(); ++right) {
        append input.get(right) to window
        while (invalid(window)) {         // update left until window is valid again
            remove input.get(left) from window
            ++left;
        }
        ans = Math.max(ans, window);           // window is guaranteed to be valid here
    }
    return ans;
}
=============================================================
private static W slidingWindowFlexibleShortest(List<T> input) {
    initialize window, ans
    int left = 0;
    for (int right = 0; right < input.size(); ++right) {
        append input.get(right) to window
        while (valid(window)) {
            ans = Math.min(ans, window);   // window is guaranteed to be valid here
            remove input.get(left) from window
            ++left;
        }
    }
    return ans;
}
===============================================================

    
}
