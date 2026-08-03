import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {

    // Aproach
    // What i did wrong: first i thought compare current element, if they are
    // different add both of them into list and increase both pointers, if they are
    // equal add one of them and increase both of them
    //

    // My solution:
    public List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != arr1[i])
                    list.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != arr2[j])
                    list.add(arr2[j]);
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != arr1[i])
                    list.add(arr1[i]);
                i++;
                j++;
            }
        }

        for (int k = i; i < n; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr1[k])
                list.add(arr1[k]);
        }
        for (int k = j; j < m; j++) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr2[k])
                list.add(arr2[k]);
        }

        return list;

    }
}
