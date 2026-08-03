public class SearchIn2DMatrix {

    // You are given an m x n 2-D integer array matrix and an integer target.

    // Each row in matrix is sorted in non-decreasing order.
    // The first integer of every row is greater than the last integer of the
    // previous row.
    // Return true if target exists within matrix or false otherwise.

    // Can you write a solution that runs in O(log(m * n)) time?
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        int rlo = 0;
        int rhi = m - 1;

        while (rlo <= rhi) {
            int mid = rlo + (rhi - rlo) / 2;
            if (matrix[lo - 1][mid] == target) {
                return true;
            } else if (matrix[lo - 1][mid] < target) {
                rlo = mid + 1;
            } else {
                rhi = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 21;

        System.out.println("Test case: target=" + target + ", expected=true");
        boolean result = new SearchIn2DMatrix().searchMatrix(matrix, target);
        System.out.println("Result=" + result);
    }
}