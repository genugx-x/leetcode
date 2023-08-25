import java.util.*;

import static java.lang.Math.max;

public class BestTimeToBuyAndSellStock {

    // 실패 코드
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = i + 1;
            for (int j = i + 1; j < prices.length; j++) {
                int sell = j + 1;
                System.out.println("buy: " + buy + "(" + prices[i] + "), sell: " + sell + "(" + prices[j] + "), profit: " + (prices[j] - prices[i]));
                max = max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // map set 을 활용한 코드 실패
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        // Map<가격, 날짜 리스트>
//        Map<Integer, List<Integer>> map = new TreeMap<>();
//        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
//        for (int i = 0; i < prices.length; i++) {
//            int price = prices[i];
//            if (!map.containsKey(price)) {
//                map.put(price, new ArrayList<>());
//            }
//            map.get(price).add(i);
//            set.add(price);
//        }
//        System.out.println(map);
//        System.out.println(set);
//        // 3,2,6,5,0,3
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            List<Integer> days = entry.getValue();
//            int buyPrice = entry.getKey();
//            for (int buyDay : days) { // 가장 낮은 가격의 동일한 날짜들을 탐색
//                for (int sellPrice : set) { // 가장 높은 가격부터 탐색
//                    if (sellPrice > buyPrice) {
//                        for (int sellDay : map.get(sellPrice)) { // 높은 가격의 동일한 날짜들
//                            if (sellDay > buyDay) {
//                                return sellPrice - buyPrice;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    public int maxProfit(int[] prices) {
//        Map<Integer, List<Integer>> map = new TreeMap<>();
//        Map<Integer, List<Integer>> descMap = new TreeMap<>(Collections.reverseOrder());
//        for (int i = 0; i < prices.length; i++) {
//            int price = prices[i];
//            if (!map.containsKey(price)) {
//                map.put(price, new ArrayList<>());
//                descMap.put(price, new ArrayList<>());
//            }
//            map.get(price).add(i);
//            descMap.get(price).add(i);
//        }
//        System.out.println(map);
//        System.out.println(descMap);
//        int max1 = findMaxProfit(map, descMap, true);
//        int max2 = findMaxProfit(descMap, map, false);
//        int max = Math.max(0, Math.max(max1, max2));
//        System.out.println(max1 + " " + max2 + " " + max);
//        return max;
//    }
//
//    public int findMaxProfit(Map<Integer, List<Integer>> m1, Map<Integer, List<Integer>> m2, boolean flag) {
//        for (Map.Entry<Integer, List<Integer>> e1 : m1.entrySet()) {
//            int k1 = e1.getKey();
//            List<Integer> v1 = e1.getValue();
//            for (Map.Entry<Integer, List<Integer>> e2 : m2.entrySet()) {
//                int k2 = e2.getKey();
//                List<Integer> v2 = e2.getValue();
//                for (Integer i1 : v1) {
//                    for (Integer i2 : v2) {
//                        if (flag) {
//                            if (i2 > i1 && k2 - k1 > 0) {
//                                return k2 - k1;
//                            }
//                        } else {
//                            if (i1 > i2 && k1 - k2 > 0) {
//                                return k1 - k2;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    // 857 ms, 55.7 MB
    public int maxProfit(int[] prices) {
        int max = 0;
        Set<Integer> set = new HashSet<>(); // 구매 가격을 기록해 중복된 가격은 재탐색을 하지 않기 위한 용도
        for (int i = 0; i < prices.length - 1; i++) {
            if (!set.contains(prices[i])) {
                for (int j = i + 1; j < prices.length; j++) {
                    max = max(max, prices[j] - prices[i]);
                }
            }
            set.add(prices[i]);
        }
        return max;
    }

}

