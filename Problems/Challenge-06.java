/*Find Right Interval:

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i. */


import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            startMap.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            Map.Entry<Integer, Integer> entry = startMap.ceilingEntry(end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
}
