import java.util.ArrayList;
import java.util.*;

public class TopKFrequentElements {

    // Input: nums = [1,2,2,3,3,3], k = 2

    // Output: [2,3]

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<int[]> arrlist = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arrlist.add(new int[] { entry.getValue(), entry.getKey() });
        }

        arrlist.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arrlist.get(i)[1];
        }

        return res;
    }
}
