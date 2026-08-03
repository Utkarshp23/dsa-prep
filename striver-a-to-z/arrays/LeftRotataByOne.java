public class LeftRotataByOne {
    // LeetCode #XXX — Problem Title
    // Difficulty: Easy/Medium/Hard
    // Topics:
    // Link: https://leetcode.com/problems/problem-title/

    public static void solution(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = temp;
    }

    public static void solution(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1)
            return;
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = temp;
    }

    /// Striver Solution
    // Function to reverse part of the array between given indices
    void reverseArray(int[] nums, int start, int end) {
        // Swap elements until start meets end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array left or right by k steps
    public int[] rotateArray(int[] nums, int k, String direction) {
        // Get array length
        int n = nums.length;

        // Edge case: do nothing if array is empty or k is 0
        if (n == 0 || k == 0)
            return nums;

        // Normalize k if greater than n
        k = k % n;

        // If rotation is to the right
        if (direction.equals("right")) {
            // Step 1: reverse entire array
            reverseArray(nums, 0, n - 1);

            // Step 2: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 3: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);
        }
        // If rotation is to the left
        else if (direction.equals("left")) {
            // Step 1: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 2: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);

            // Step 3: reverse entire array
            reverseArray(nums, 0, n - 1);
        }

        // Return the rotated array
        return nums;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(solution(new int[] { 1, 2, 3 })); // expected:

        // Test case 2
        System.out.println(solution(new int[] {})); // expected:
    }

}
