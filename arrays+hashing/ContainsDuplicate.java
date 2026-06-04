import java.util.HashSet;

/*
 * LeetCode #217 - Contains Duplicate
 * Difficulty: Easy | Pattern: HashSet for O(1) existence check
 *
 * Time:  O(n)
 * Space: O(n)
 *
 * Key insight: HashSet.add() returns false if element already present —
 *              no need for a separate contains() call.
 *
 * Trade-off:   Sort approach is O(n log n) / O(1) space, but HashSet is faster.
 * Watch out:   Don't sort when the question just asks "does a duplicate exist."
 */
public class ContainsDuplicate {

    // My solution
    public static boolean hasDuplicateMine(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    // Best solution — same idea, but HashSet.add() returns false if already present
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1, 2, 3, 1})); // true
        System.out.println(hasDuplicate(new int[]{1, 2, 3, 4})); // false
        System.out.println(hasDuplicate(new int[]{1}));           // false
    }
}
