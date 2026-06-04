import java.util.HashMap;

/*
 * LeetCode #242 - Valid Anagram
 * Difficulty: Easy | Pattern: Character frequency counting
 *
 * Time:  O(n)  — both approaches
 * Space: My solution O(n) HashMap | Best solution O(1) fixed int[26]
 *
 * Key insight: Increment freq for each char in s, decrement for each char in t.
 *              Anagram ↔ every frequency ends at 0.
 *
 * vs HashMap:  int[26] is faster — no boxing, no hashing overhead, fixed memory.
 * Follow-up:   Unicode input? Switch back to HashMap<Character, Integer>.
 */
public class ValidAnagram {

    // My solution — HashMap approach
    public boolean isAnagramMine(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    // Best solution — int[26] array, O(1) space, no boxing overhead
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "car"));         // false
        System.out.println(sol.isAnagram("a", "ab"));            // false
    }
}
