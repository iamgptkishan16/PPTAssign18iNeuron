/*
💡 2. **Sort Colors**

Given an array `nums` with `n` objects colored red, white, or blue, sort them **[in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

**Example 1:**
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]


 */

 import java.util.*;
 public class SortColors {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before sorting: " + Arrays.toString(nums));

        sortColors(nums);

        System.out.println("After sorting: " + Arrays.toString(nums));
    }
}
