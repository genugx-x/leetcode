import java.util.Arrays;

public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
//        System.out.println(Arrays.toString(solution.twoSum5(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(solution.twoSum5(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum5(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(solution.twoSum5(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11)));
        System.out.println(Arrays.toString(solution.twoSum5(
                new int[]{-1000, 1000, -999, 999, 1001, -1001, -1000, 1000, -999, 999,
                        1001, -1001, 2, -1000, 1000, -999, 999, 1001, -1001, -1000, 1000,
                        -999, 999, 1001, -1001, 5, -1000, 1000, -999, 999, 1001, -1001, -1000,
                        1000, -999, 999, 1001, -1001
                }, 7)));
    }
}
