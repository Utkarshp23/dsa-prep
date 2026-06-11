import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    // Given a string s, find the length of the longest substring without duplicate
    // characters.

    // A substring is a contiguous sequence of characters within a string.

    // Example 1:

    // Input: s = "zxyzxyz"

    // Output: 3
    // Explanation: The string "xyz" is the longest without duplicate characters.

    // Example 2:

    // Input: s = "xxxx"

    // Output: 1
    // Constraints:

    // 0 <= s.length <= 1000
    // s may consist of printable ASCII characters.

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int lmax = 0;
        while (i < n) {
            System.out.println("\n--- Outer loop iteration: i = " + i + " ---");
            Set<Character> curSet = new HashSet<>();
            // curSet.add(s.charAt(i));
            // j = i + 1;
            j = i;
            System.out.println("Reset i to j: i = " + i + ", j = " + j);
            System.out.println("Current set: " + curSet);
            while (j < n && !curSet.contains(s.charAt(j))) {
                System.out.println("Adding character: " + s.charAt(j) + " at index " + j);
                curSet.add(s.charAt(j));
                System.out.println("Set after adding: " + curSet);
                j++;
            }
            System.out.println("Inner loop ended. j = " + j + ", char at j: " + (j < n ? s.charAt(j) : "END"));

            lmax = Math.max(lmax, j - i);
            System.out.println("Current substring length: " + (j - i) + ", Current max: " + lmax);
            System.out.println("Incrementing i from " + i + " to " + (i + 1));
            i++;
        }
        System.out.println("\nFinal max length: " + lmax);
        return lmax;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solution = new LongestSubstringWithoutRepeatingChars();
        String test = "zxyzxyz";
        int result = solution.lengthOfLongestSubstring(test);
        System.out.println("Input: \"" + test + "\"");
        System.out.println("Output: " + result);
        System.out.println("Expected: 3");
    }
}
