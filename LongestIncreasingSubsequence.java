/*
💡 7. **Longest Increasing Subsequence**

Given an integer array `nums`, return *the length of the longest **strictly increasing***

***subsequence***

.

**Example 1:**

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

*/


import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int length = lengthOfLIS(nums);

        System.out.println("Length of the longest increasing subsequence: " + length);
    }
}
