/* Valid Triangle Number:

Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle. */\

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int k = 2; k < nums.length; k++) {
            int i = 0;
            int j = k - 1;
            
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
