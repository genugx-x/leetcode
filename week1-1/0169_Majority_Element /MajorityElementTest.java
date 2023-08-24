public class MajorityElementTest {

    static MajorityElement solution = new MajorityElement();

    public static void main(String[] args) {
        example1();
        example2();
    }

    static void example1() {
        int[] nums = new int[]{3, 2, 3};
        int result = solution.majorityElement(nums);
        System.out.println("Example 1 : " + (result == 3 ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("Example 2 : " + (result == 2 ? "Passed" : "Failed"));
    }

}
