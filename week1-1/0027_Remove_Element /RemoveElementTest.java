import java.util.Arrays;

public class RemoveElementTest {

    static RemoveElement removeElement = new RemoveElement();

    public static void main(String[] args) {
        example1();
        example2();
    }

    static void example1() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        removeElement.removeElement(nums, val);
        System.out.println("Example 1 : " + (Arrays.equals(new int[]{2, 2, -1, -1}, nums) ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        removeElement.removeElement(nums, val);
        System.out.println("Example 2 : " + (Arrays.equals(new int[]{0, 1, 3, 0, 4, -1, -1, -1}, nums) ? "Passed" : "Failed"));
    }

}
