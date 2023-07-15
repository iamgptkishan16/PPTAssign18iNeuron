/*
💡 5. **Contains Duplicate**

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example 1:**
Input: nums = [1,2,3,1]
Output: true


 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        boolean containsDup = containsDuplicate(nums);

        System.out.println("Contains duplicate: " + containsDup);
    }
}
