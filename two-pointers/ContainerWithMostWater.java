public class ContainerWithMostWater {

    // You are given an integer array heights where heights[i] represents the height
    // of the
    // i
    // t
    // h
    // i
    // th
    // bar.

    // You may choose any two bars to form a container. Return the maximum amount of
    // water a container can store.

    // Example 1:

    // Input: height = [1,7,2,5,4,7,3,6]

    // Output: 36

    // Input: height = [2,2,2]

    // Output: 4

    public int maxArea(int[] heights) {
        int n = heights.length;
        if (n < 2)
            return 0;
        int i = 0;
        int j = n - 1;
        int maxWater = 0;
        while (i < j) {
            // System.out.println("i:" + heights[i] + "|j:" + heights[j]);
            int curHeight = Math.min(heights[i], heights[j]);
            int curLen = j - i;

            maxWater = Math.max(maxWater, curLen * curHeight);
            // System.out.println("|" + curHeight + "*" + curLen + "|=" + maxWater);

            if (heights[i] > heights[j]) {
                j--;
            } else if (heights[i] < heights[j]) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6 };
        int result = solver.maxArea(heights);
        System.out.println(result); // expected 36
    }

}
