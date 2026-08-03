public class MoveZerosToEnd {

    // My Approach
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        if (n <= 1)
            return;

        while (i < n && nums[i] != 0)
            i++;

        if (i == n - 1)
            return;

        int j = i + 1;
        while (i < n && j < n) {
            j = i + 1;
            while (j < n && nums[j] == 0)
                j++;
            if (i < n && j < n) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
        }
    }

    // SnowBall Solution
    public void moveZeroes1(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }
}
