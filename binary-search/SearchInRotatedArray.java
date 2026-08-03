
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[lo] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String s = "Utkarsh Pawar";
        Character m = s.chars().mapToObj(c -> (char) c).filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst()
                .orElse(null);

        System.out.println("Charactere:" + m);
    }
}