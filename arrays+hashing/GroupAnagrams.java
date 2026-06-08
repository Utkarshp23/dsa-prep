import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    // Input: strs = ["act","pots","tops","cat","stop","hat"]

    // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortedString = sortString(s);
            map.putIfAbsent(sortedString, new ArrayList<String>());
            map.get(sortedString).add(s);
        }

        return new ArrayList<>(map.values());

    }

    public String sortString(String original) {
        // 1. Convert string to char array
        char[] chars = original.toCharArray();

        // 2. Sort the array (Uses Dual-Pivot Quicksort)
        Arrays.sort(chars);

        // 3. Convert back to string
        String sorted = new String(chars);

        return sorted;
    }

    public static void main(String[] args) {

    }
}
