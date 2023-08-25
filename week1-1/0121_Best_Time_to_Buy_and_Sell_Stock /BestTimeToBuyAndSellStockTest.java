import java.io.File;

public class BestTimeToBuyAndSellStockTest {

    static BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    static void example1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println("Example 1 : " + (result == 5 ? "Passed" : "Failed"));
    }

    static void example2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int result = solution.maxProfit(prices);
        System.out.println("Example 2 : " + (result == 0 ? "Passed" : "Failed"));
    }

    static void example3() {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int result = solution.maxProfit(prices);
        System.out.println("Example 3 : " + (result == 4 ? "Passed" : "Failed"));
    }

    static void example4() {
        int[] prices = new int[]{33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20,
                19, 18, 17, 16, 15, 18, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int result = solution.maxProfit(prices);
        System.out.println("Example 4 : " + (result == 3 ? "Passed" : "Failed"));
    }

    static void example5() {
        int[] prices = new int[]{1, 2};
        int result = solution.maxProfit(prices);
        System.out.println("Example 5 : " + (result == 1 ? "Passed" : "Failed"));
    }
}
