import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayTest {

    static RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();

    public static void main(String[] args) {
        example1();
        example2();
    }

    static void example1() {
        int[] nums = new int[]{1, 2, 2, 3};
        int size = solution.removeDuplicates(nums);
        System.out.println("Example 1 : " + (Arrays.equals(new int[]{1, 2, 3, 0}, nums) ? "Passed" : "Failed") + " [" + size + "]");
        System.out.println();
    }

    static void example2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = solution.removeDuplicates(nums);
        System.out.println("Example 1 : " + (Arrays.equals(new int[]{0, 1, 2, 3, 4, 0, 0, 0, 0, 0}, nums) ? "Passed" : "Failed") + " [" + size + "]");
    }
}
