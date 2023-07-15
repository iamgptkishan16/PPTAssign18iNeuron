/*
💡 6. **Minimum Number of Arrows to Burst Balloons**

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points` where `points[i] = [xstart, xend]` denotes a balloon whose **horizontal diameter** stretches between `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up **directly vertically** (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is **burst** by an arrow shot at `x` if `xstart <= x <= xend`. There is **no limit** to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array `points`, return *the **minimum** number of arrows that must be shot to burst all balloons*.

**Example 1:**
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 
*/

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the points array based on the end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Start with one arrow
        int end = points[0][1]; // End coordinate of the first balloon

        // Iterate through the balloons
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the previous balloon ends,
            // we need an additional arrow to burst this balloon
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        int minArrows = findMinArrowShots(points);

        System.out.println("Minimum arrows required: " + minArrows);
    }
}
