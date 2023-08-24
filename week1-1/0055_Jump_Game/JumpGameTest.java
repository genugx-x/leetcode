import java.util.Arrays;

public class JumpGameTest {

    static JumpGame solution = new JumpGame();

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    static void example1() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean result = solution.canJump(nums);
        System.out.println("Example 1 : " + (result == true ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] nums = new int[]{0};
        boolean result = solution.canJump(nums);
        System.out.println("Example 2 : " + (result == true ? "Passed" : "Failed"));
    }

    static void example3() {
        int[] nums = new int[]{2, 5, 0, 0};
        boolean result = solution.canJump(nums);
        System.out.println("Example 3 : " + (result == true ? "Passed" : "Failed"));
    }
}
