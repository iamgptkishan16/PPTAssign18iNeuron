/*
💡 4. **Maximum Gap**

Given an integer array `nums`, return *the maximum difference between two successive elements in its sorted form*. If the array contains less than two elements, return `0`.

You must write an algorithm that runs in linear time and uses linear extra space.

**Example 1:**
Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.


*/

import java.util.Arrays;

public class MaximumGap {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int n = nums.length;

        // Find the minimum and maximum elements in the array
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < n; i++) {
            minNum = Math.min(minNum, nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }

        // Calculate the average gap between elements
        int averageGap = (int) Math.ceil((double) (maxNum - minNum) / (n - 1));

        // Calculate the number of buckets needed
        int numBuckets = (maxNum - minNum) / averageGap + 1;

        // Initialize the buckets
        int[] minBuckets = new int[numBuckets];
        int[] maxBuckets = new int[numBuckets];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);

        // Put the elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (nums[i] - minNum) / averageGap;
            minBuckets[bucketIndex] = Math.min(minBuckets[bucketIndex], nums[i]);
            maxBuckets[bucketIndex] = Math.max(maxBuckets[bucketIndex], nums[i]);
        }

        // Calculate the maximum gap
        int maxGap = 0;
        int previousMax = minNum;
        for (int i = 0; i < numBuckets; i++) {
            // Skip empty buckets
            if (minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE)
                continue;

            maxGap = Math.max(maxGap, minBuckets[i] - previousMax);
            previousMax = maxBuckets[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};

        int maxGap = maximumGap(nums);

        System.out.println("Maximum Gap: " + maxGap);
    }
}
