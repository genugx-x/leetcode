import static java.lang.Math.max;

public class BestTimeToBuyAndSellStock2 {

    // 총 수익 구하기
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = i + 1;
            for (int j = i + 1; j < prices.length; j++) {
                int sell = j + 1;
                max = max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

}

