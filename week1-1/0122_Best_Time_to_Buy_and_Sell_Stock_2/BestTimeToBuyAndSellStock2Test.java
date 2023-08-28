public class BestTimeToBuyAndSellStock2Test {

    static BestTimeToBuyAndSellStock2 solution = new BestTimeToBuyAndSellStock2();

    public static void main(String[] args) {
        example1();
    }

    static void example1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println("Example 1 : " + (result == 7 ? "Passed" : "Failed"));
    }
}
