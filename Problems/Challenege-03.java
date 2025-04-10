/*Find Smallest Letter Greater Than Target:

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters. */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (letters[mid] <= target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return letters[low % letters.length];
    }
}


