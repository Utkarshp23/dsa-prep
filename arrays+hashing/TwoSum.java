import java.util.Arrays;
import java.util.HashMap;

/*
 * LeetCode #1 - Two Sum
 * Difficulty: Easy | Pattern: Complement lookup in HashMap
 *
 * Time:  O(n)
 * Space: O(n)
 *
 * Key insight: For each nums[i], complement = target - nums[i].
 *              If complement was seen before → pair found.
 *              Add to map AFTER the check so you don't reuse the same index.
 *
 * Watch out:   Brute force O(n²) is the trap. Any "find a pair" problem → think HashMap first.
 */
public class TwoSum {

    // My solution
    public int[] twoSumMine(int[] nums, int target) {
        int[] ans = {0, 0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    // Best solution — same logic, named 'complement' for clarity, cleaner return
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 3}, 6)));          // [0, 1]
    }
}
