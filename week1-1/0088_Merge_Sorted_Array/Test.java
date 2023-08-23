import java.util.Arrays;

public class Test {

    static Solution solution = new Solution();

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }

    static void example1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Example 1 : " + (Arrays.equals(new int[]{1, 2, 2, 3, 5, 6}, nums1) ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] nums1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{};
        int n = 0;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Example 2 : " + (Arrays.equals(new int[]{1}, nums1) ? "Passed" : "Failed"));

    }

    static void example3() {
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Example 3 : " + (Arrays.equals(new int[]{1}, nums1) ? "Passed" : "Failed"));
    }

    static void example4() {
        int[] nums1 = new int[]{2, 0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Example 4 : " + (Arrays.equals(new int[]{1, 2}, nums1) ? "Passed" : "Failed"));
    }

}
