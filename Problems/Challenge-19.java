/*H-Index II:

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in non-descending order, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

You must write an algorithm that runs in logarithmic time.

  */

  class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        int hIndex = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papersWithAtLeastThisManyCitations = n - mid;

            if (citations[mid] >= papersWithAtLeastThisManyCitations) {
                hIndex = papersWithAtLeastThisManyCitations;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return hIndex;
    }
}
