/*
💡 8. **132 Pattern**

Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return `true` *if there is a **132 pattern** in* `nums`*, otherwise, return* `false`*.*

**Example 1:**
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.


*/


import java.util.Stack;

public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n = nums.length;
        int[] minValues = new int[n];
        minValues[0] = nums[0];

        // Find the minimum value at each index
        for (int i = 1; i < n; i++) {
            minValues[i] = Math.min(minValues[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        // Iterate from right to left to find the 132 pattern
        for (int i = n - 1; i >= 0; i--) {
            // If the current element is greater than the minimum value at that index
            if (nums[i] > minValues[i]) {
                // Remove the elements from the stack that are less than the current minimum value
                while (!stack.isEmpty() && stack.peek() <= minValues[i]) {
                    stack.pop();
                }

                // If there is an element in the stack that is less than the current element,
                // return true (132 pattern found)
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }

                // Push the current element to the stack
                stack.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};

        boolean has132pattern = find132pattern(nums);

        System.out.println("Has 132 pattern: " + has132pattern);
    }
}
