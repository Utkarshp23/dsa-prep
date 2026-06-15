public class ProductExceptSelf {

    // Input: nums = [1,2,4,6]

    // Output: [48,24,12,8]

    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int n = nums.length;
        int[] ans = new int[nums.length];
        // for (int i : nums) {
        // if (nums[i] != 0)
        // totalProduct *= i;
        // }

        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] != 0) {
        // ans[i] = totalProduct / nums[i];
        // } else {
        // ans[i] = totalProduct;
        // }
        // }

        int[] pfx = new int[n];
        int[] sfx = new int[n];

        pfx[0] = 1;
        sfx[n - 1] = 1;

        int curProductp = 1;
        int curProducts = 1;
        for (int i = 1; i < n; i++) {
            curProductp *= nums[i - 1];
            pfx[i] = curProductp;
            curProducts *= nums[n - i];
            sfx[n - i - 1] = curProducts;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(pfx[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(sfx[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            ans[i] = pfx[i] * sfx[i];
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] test = { 0, -6, 0, 0, 0 };
        ProductExceptSelf solver = new ProductExceptSelf();
        int[] result = solver.productExceptSelf(test);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
