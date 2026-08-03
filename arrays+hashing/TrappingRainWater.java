import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int preMax = 0;
        int sufMax = 0;
        pre[0] = 0;
        suf[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            preMax = Math.max(preMax, height[i - 1]);
            pre[i] = preMax;
            sufMax = Math.max(sufMax, height[n - i]);
            suf[n - i - 1] = sufMax;
        }

        System.out.println("pre: " + Arrays.toString(pre));
        System.out.println("suf: " + Arrays.toString(suf));

        int water = 0;
        for (int i = 0; i < n; i++) {
            water = water + Math.min(pre[i], suf[i] - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
        System.out.println(solution.trap(height));
    }
}
