import java.util.Arrays;

public class RotateArrayTest {

    static RotateArray solution = new RotateArray();

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }

    static void example1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println("Example 1 : " + (Arrays.equals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums) ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        int k = 2;
        solution.rotate(nums, k);
        System.out.println("Example 2 : " + (Arrays.equals(new int[]{3, 99, -1, -100}, nums) ? "Passed" : "Failed"));
    }

    static void example3() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 520;
        solution.rotate(nums, k);
        System.out.println("Example 3 : " + (Arrays.equals(new int[]{6, 7, 1, 2, 3, 4, 5}, nums) ? "Passed" : "Failed"));
    }

    static void example4() {
        int[] nums = new int[]{99};
        int k = 555;
        solution.rotate(nums, k);
        System.out.println("Example 4 : " + (Arrays.equals(new int[]{99}, nums) ? "Passed" : "Failed"));
    }

}
