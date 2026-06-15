import java.util.Arrays;

public class TwoSumII {

    // Given an array of integers numbers that is sorted in non-decreasing order.

    // Return the indices (1-indexed) of two numbers, [index1, index2], such that
    // they add up to a given target number target and index1 < index2. Note that
    // index1 and index2 cannot be equal, therefore you may not use the same element
    // twice.

    // There will always be exactly one valid solution.

    // Your solution must use
    // O
    // (
    // 1
    // )
    // O(1) additional space.

    // Example 1:

    // Input: numbers = [1,2,3,4], target = 3

    // Output: [1,2]
    // Explanation:
    // The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1,
    // index2 = 2. We return [1, 2].

    // Constraints:

    // 2 <= numbers.length <= 1000
    // -1000 <= numbers[i] <= 1000
    // -1000 <= target <= 1000

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int curSum = numbers[i] + numbers[j];
            if (curSum > target) {
                j--;
            } else if (curSum < target) {
                i++;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumII solver = new TwoSumII();
        int[] numbers = { 1, 2, 3, 4 };
        int target = 3;
        int[] result = solver.twoSum(numbers, target);
        System.out.printf("Result: [%d, %d]%n", result[0], result[1]);
    }
}
